package uk.co.skyem.random.matcherThing1

import kotlin.text.Regex

public class StartEndMatcher(matches: Matcher, starts: Boolean, ends: Boolean) : Matcher, ToRegex {
    val matcher = matches
    val starts = starts
    val ends = ends

    override fun toKotlinRegex(): Regex {
        if (matcher is ToRegex)
            return Regex((if (ends) ".*" else "") + matcher.toKotlinRegex().pattern + (if (starts) ".*" else ""),
                            matcher.toKotlinRegex().options)
        else
            throw UnsupportedOperationException("Cannot convert matcher to regex")
    }

    override fun canToRegex(): Boolean {
        return matcher.canToRegex();
    }

    override fun useOn(string: String): Matches {
        throw UnsupportedOperationException()
    }

}
