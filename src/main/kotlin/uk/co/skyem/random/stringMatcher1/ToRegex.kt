package uk.co.skyem.random.stringMatcher1

import java.util.regex.Pattern
import kotlin.text.Regex

public interface ToRegex {
    fun toRegexString(): String {
        return toKotlinRegex().pattern
    }
    fun toKotlinRegex(): Regex
    fun toRegexPattern(): Pattern {
        return toKotlinRegex().toPattern()
    }

    fun canToRegex(): Boolean
}