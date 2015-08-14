package uk.co.skyem.random.stringMatcher1

import kotlin.text.Regex

public class StartEndMatcher(matches: Matcher, starts: Boolean, ends: Boolean, exclusive: Boolean) : Matcher, ToRegex {
	override fun equals(other: Any?): Boolean {
		if (other != null)
			if (other is StartEndMatcher)
				if (other.matcher == this.matcher
						&& other.starts == this.starts
						&& other.ends == this.ends
						&& other.exclusive == this.exclusive)
					return true
		return false
	}

	val matcher = matches
	val starts = starts
	val ends = ends
	val exclusive = exclusive

	override fun toKotlinRegex(): Regex {
		if (matcher is ToRegex) {
			if (!exclusive)
				return Regex((if (ends) ".*" else "") + matcher.toKotlinRegex().pattern + (if (starts) ".*" else ""),
						matcher.toKotlinRegex().options)
			else if (exclusive && ends)
				return Regex(".*(?=" + matcher.toKotlinRegex().pattern + ")")
		}
		throw UnsupportedOperationException("Cannot convert matcher to regex")
	}

	override fun canToRegex(): Boolean {
		return matcher.canToRegex() || (exclusive && starts)
	}

	override fun useOn(string: String): Matches {
		// This might be a really bad way of doing it, but I'm stupid so I don't know a better way...
		// get the matches
		val matches = matcher.useOn(string)
		if (starts && ends) { // this essentially means match everything if something is found
			// match the whole thing IF something is found.
			if (matches.matchFound()) {
				if (!exclusive) // return the whole string
					return Matches(arrayOf(Match(string, 0, string.length())))
				else // return the whole string, excluding the things that were matched, basically, a match().invert
					return matcher.invert().useOn(string)
			} else return Matches()
		} else if (!starts && !ends) { // this is essentially just passing the matches through
			if (!exclusive)
				return matches
			else
				return Matches(); // in this case, it returns nothing
		} else if (starts) { // if it starts with something match the rest
			// so... we start from the first match going left to right and take the position of the match
			val start = matches.first().start
			if (exclusive) {
				val end = matches.first().end
				return Matches(arrayOf(Match(string.substring(end), end, string.length())))
			} else    // and make a substring starting from that until the end then make a match with it and return it
				return Matches(arrayOf(Match(string.substring(start), start, string.length())))
		} else /*if (ends)*/ {
			// so... we start from the first match going right to left (last match) and take it's position
			val end = matches.last().end
			if (exclusive) {
				val start = matches.last().start
				return Matches(arrayOf(Match(string.substring(0, start), 0, start)))
			} else // and make a substring starting from the start of string until that then make a match with it and return it
				return Matches(arrayOf(Match(string.substring(0, end), 0, end)))
		}
	}

}
