package uk.co.skyem.random.stringMatcher1

/**
 * Inverts a match
 */
internal class Inverter(matcher: Matcher) : Matcher {
	override fun equals(other: Any?): Boolean {
		if (other != null) {
			if (other is Inverter) {
				if (other.matcher == this.matcher) {
					return true
				}
			}
		}
		return false;
	}

	val matcher = matcher

	override fun canToRegex(): Boolean {
		return false
	}

	override fun useOn(string: String): Matches {
		// get the old result of matching the string
		val oldResult = matcher.useOn(string)
		// then invert it

		var newResults = listOf<Match>()

		var lastPosition = 0
		// loop through the old matches?
		oldResult.forEach {
			// get the substring from the last end position to the start of the match
			val substring = string.substring(lastPosition, it.start)
			//println(": $lastPosition ${it.start} " + substring)
			// then create a match for the thing...
			val match = Match(substring, lastPosition, it.start)
			// then stick it into an list of matches
			newResults += match
			// then save the new last position
			lastPosition = it.end
		}
		// and if there is more to go...
		if (lastPosition != string.length()) {
			newResults += Match(string.substring(lastPosition, string.length()), lastPosition, string.length())
		}

		return Matches(newResults)
	}
}
