package uk.co.skyem.random.matcherThing1

import kotlin.platform.platformStatic
import kotlin.text.RegexOption

public interface Matcher {
    fun canToRegex(): Boolean

    fun useOn(string: String): Matches
}