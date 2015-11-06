package uk.co.skyem.random.stringMatcher1

// TODO: Be as lazy as possible.
internal class Matches(matches: Array<Match>) : List<Match> {
	constructor(matches: Collection<Match>) : this(matches.toTypedArray())
	constructor()                           : this(arrayOf())
	
	override val size = matches.size

	companion object Matches {
		fun arrayEqual(a: Array<Match>, b: Array<Match>): Boolean {
			if (a.size != b.size) return false
			a.forEach {
				val thing = it
				// If an element in a has been found in b...
				var oneFound = false
				b.forEach {
					oneFound = oneFound || thing == it
				}
				// if one is not found, return false
				if (!oneFound) return false
			}
			return true
		}
	}

	private val matches = matches

	fun matchFound(): Boolean {
		return matches.isNotEmpty()
	}

	fun first(): Match {
		return matches.first()
	}

	fun last(): Match {
		return matches.last()
	}

	override fun isEmpty(): Boolean {
		return matches.isEmpty()
	}

	override fun iterator(): Iterator<Match> {
		return matches.iterator()
	}

	override fun get(index: Int): Match {
		return matches.get(index)
	}

	override fun contains(element: Match): Boolean {
		return matches.contains(element)
	}

	override fun listIterator(): ListIterator<Match> {
		return matches.toList().listIterator()
	}

	override fun listIterator(index: Int): ListIterator<Match> {
		return matches.toList().listIterator(index)
	}

	override fun subList(fromIndex: Int, toIndex: Int): List<Match> {
		return matches.toList().subList(fromIndex, toIndex)
	}

	override fun equals(other: Any?): Boolean {
		if (other != null && other is uk.co.skyem.random.stringMatcher1.Matches && Matches.arrayEqual(this.matches, other.matches))
			return true
		else
			return false
	}
	
	override fun indexOf(element: Match): Int {
		return matches.indexOf(element)
	}
	
	override fun containsAll(elements: Collection<Match>): Boolean {
		return arrayEqual(elements.toTypedArray(), matches)
	}

	override fun lastIndexOf(element: Match): Int {
		return matches.lastIndexOf(element)
	}

	// TODO: Store matcher object, so matches can be inverted?
}
