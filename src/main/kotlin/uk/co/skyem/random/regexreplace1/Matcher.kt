package uk.co.skyem.random.regexreplace1

import kotlin.platform.platformStatic
import kotlin.text.RegexOption

public interface Matcher {
    fun useOn(string: String): Matches
}