package uk.co.skyem.random.matcherThing1

import java.util.*
import java.util.regex
import java.util.regex.Pattern
import kotlin.text.Regex
import kotlin.text.RegexOption

/**
 * An exact matcher matches a string exactly, no regex, etc...
 */
public class ExactMatcher(matches: String, caseInsensitive: Boolean) :
        RegexMatcher(if (caseInsensitive) "(?i)" + Regex.escape(matches) else Regex.escape(matches)) {
    constructor(matches: String): this(matches, false)

    val matchString = matches
    val caseInsensitive = caseInsensitive

    override fun useOn(string: String): Matches {
        val matches = ArrayList<Match>()
        val regexMatch = matchRegex.matchAll(string).forEach {
            matches.add(Match(it.value, it.range.start, it.range.end))
        }
        return Matches(matches)
    }
}