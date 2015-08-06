package uk.co.skyem.random.regexreplace1

import java.util.*
import java.util.regex
import java.util.regex.Pattern
import kotlin.text.Regex

/**
 * An exact matcher matches a string exactly, no regex, etc...
 */
public class ExactMatcher(matches: String) : Matcher, ToRegex {
    val matchString = matches;

    override fun toRegex(): String {
        return Regex.escape(matchString)
    }

    override fun canToRegex(): Boolean {
        return true
    }

    override fun useOn(string: String): Matches {
        val matches = ArrayList<Match>()
        val regexMatch = Regex(toRegex()).matchAll(string).forEach {
            matches.add(Match(it.value, it.range.start, it.range.end))
        }
        return Matches(matches)
    }
}