package uk.co.skyem.random.matcherThing1

// TODO: Be as lazy as possible.
public class Matches(matches: Array<Match>) : List<Match> {
    constructor(matches: Collection<Match>) : this(matches.toTypedArray())
    constructor()                           : this(arrayOf())

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

    override fun size(): Int {
        return matches.size()
    }

    override fun isEmpty(): Boolean {
        return matches.isEmpty()
    }

    override fun contains(o: Any?): Boolean {
        return matches.contains(o)
    }

    override fun iterator(): Iterator<Match> {
        return matches.iterator()
    }

    override fun containsAll(c: Collection<Any?>): Boolean {
        var contain = false
        c.forEach { contain = contain or contains(it) }
        return contain
    }

    override fun get(index: Int): Match {
        return matches.get(index)
    }

    override fun indexOf(o: Any?): Int {
        return matches.indexOf(o)
    }

    override fun lastIndexOf(o: Any?): Int {
        return matches.lastIndexOf(o)
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
}