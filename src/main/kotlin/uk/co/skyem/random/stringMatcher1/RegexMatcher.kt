package uk.co.skyem.random.stringMatcher1

import java.util.*
import java.util.regex.Pattern
import kotlin.text.Regex
import kotlin.text.RegexOption
import kotlin.text.toRegex

/**
 * A matcher that matches a regex
 */
public open class RegexMatcher(pattern: Regex) : Matcher, ToRegex {
    constructor(pattern: String): this(pattern.toRegex())
    constructor(pattern: String, flag: RegexOption): this(pattern.toRegex(flag))
    constructor(pattern: String, flags: Set<RegexOption>): this(pattern.toRegex(flags))
    constructor(pattern: Pattern): this(pattern.toRegex())
    constructor(pattern: String, flags: Int): this(pattern.toPattern(flags))

    val matchRegex = pattern

    override fun toKotlinRegex(): Regex {
        return matchRegex
    }

    override fun canToRegex(): Boolean {
        return true
    }

    override fun useOn(string: String): Matches {
        val matches = ArrayList<Match>()

        try { // no, I don't want to do this, but... https://youtrack.jetbrains.com/issue/KT-8763
            matchRegex.matchAll(string).forEach {
                // println(": " + it.value + " " + it.range.start + " " + it.range.end)
                matches.add(Match(it.value, it.range.start, it.range.end))
            }
        } catch (e: java.lang.IndexOutOfBoundsException) {
            if (matches.last().string == "") {
                matches.remove(matches.size() - 1)
                // println(matches.last())
            }
        }

        return Matches(matches)
    }
}
