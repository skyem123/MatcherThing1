package uk.co.skyem.random.stringMatcher1

public class Match(string: String, start: Int, end: Int) {
    val start = start
    val end = end
    val string = string

    override fun toString(): String {
        return "$start $end $string"
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) { return false }
        if (other is Match) {
            if (other.start == this.start && other.end == this.end && other.string == this.string)
                return true
        }
        return false
    }
}