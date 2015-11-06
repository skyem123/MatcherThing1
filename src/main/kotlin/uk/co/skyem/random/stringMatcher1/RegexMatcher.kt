package uk.co.skyem.random.stringMatcher1

import java.util.*
import java.util.regex.Pattern
import kotlin.text.Regex
import kotlin.text.RegexOption

/**
 * A matcher that matches a regex
 */
internal open class RegexMatcher(pattern: Regex) : Matcher {
	override fun equals(other: Any?): Boolean {
		if (other != null && other is RegexMatcher)
			if (other.toRegexString() == this.toRegexString() &&
					other.toKotlinRegex().options == this.toKotlinRegex().options)
				return true
		return false
	}

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
		
		matchRegex.findAll(string).forEach {
			println(": " + it.value + " " + it.range.start + " " + it.range.end)
			matches.add(Match(it.value, it.range.start, it.range.end + 1))
		}

		return Matches(matches)
	}
}
