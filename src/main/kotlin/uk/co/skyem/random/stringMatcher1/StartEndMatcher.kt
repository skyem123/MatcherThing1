package uk.co.skyem.random.stringMatcher1

import kotlin.text.Regex

public class StartEndMatcher(matches: Matcher, starts: Boolean, ends: Boolean, exclusive: Boolean) : Matcher, ToRegex {
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
        println(string)
        // This might be a really bad way of doing it, but I'm stupid so I don't know a better way...
        // get the matches
        val matches = matcher.useOn(string)
        if (starts && ends) { // this essentially means match everything if something is found
            // match the whole thing IF something is found.
            if (matches.matchFound()) {
                if (!exclusive) // return the whole string
                    return Matches(arrayOf(Match(string, 0, string.length())))
                else { // return the whole string, excluding the things that were matched
                    throw UnsupportedOperationException("Not Yet Implemented") // TODO: Implement me
                }

            } else return Matches()
        } else if (!starts && !ends) { // this is essentially just passing the matches through
            if (!exclusive)
                return matches
            else
                return Matches(); // in this case, it returns nothing
        } else if (starts) { // if it starts with something match the rest
            if (exclusive) throw UnsupportedOperationException("Not Yet Implemented") // TODO: Implement me
            // so... we start from the first match going left to right and take the position of the match
            val start = matches.first().start
            // and make a substring starting from that until the end then make a match with it and return it
            return Matches(arrayOf(Match(string.substring(start), start, string.length())))
        } else /*if (ends)*/ {
            if (exclusive) throw UnsupportedOperationException("Not Yet Implemented") // TODO: Implement me
            // so... we start from the first match going right to left (last match) and take it's position
            val end = matches.last().end + 1
            // and make a substring starting from the start of string until that then make a match with it and return it
            return Matches(arrayOf(Match(string.substring(0, end), 0, end)))
        }
    }

}
