package uk.co.skyem.random.stringMatcher1

import java.util.*
import java.util.regex.Pattern
import kotlin.text.Regex
import kotlin.text.RegexOption

/**
 * A matcher that matches a regex
 */
internal open class RegexMatcher(pattern: Regex, removeExcessEmptyMatches: Boolean) : Matcher {
	override fun equals(other: Any?): Boolean {
		if (other != null && other is RegexMatcher)
			if (other.toRegexString() == this.toRegexString() &&
					other.toKotlinRegex().options == this.toKotlinRegex().options &&
					other.removeExcessEmptyMatches == this.removeExcessEmptyMatches)
				return true
		return false
	}

	constructor(pattern: String, removeExcessEmptyMatches: Boolean): this(pattern.toRegex(), removeExcessEmptyMatches)
	constructor(pattern: String, flag: RegexOption, removeExcessEmptyMatches: Boolean): this(pattern.toRegex(flag), removeExcessEmptyMatches)
	constructor(pattern: String, flags: Set<RegexOption>, removeExcessEmptyMatches: Boolean): this(pattern.toRegex(flags), removeExcessEmptyMatches)
	constructor(pattern: Pattern, removeExcessEmptyMatches: Boolean): this(pattern.toRegex(), removeExcessEmptyMatches)
	constructor(pattern: String, flags: Int, removeExcessEmptyMatches: Boolean): this(pattern.toPattern(flags), removeExcessEmptyMatches)

	constructor(pattern: Regex): this(pattern, false)
	constructor(pattern: String): this(pattern, false)
	constructor(pattern: String, flag: RegexOption): this(pattern, flag, false)
	constructor(pattern: String, flags: Set<RegexOption>): this(pattern, flags, false)
	constructor(pattern: Pattern): this(pattern, false)
	constructor(pattern: String, flags: Int): this(pattern, flags, false)

	val matchRegex = pattern
	val removeExcessEmptyMatches = removeExcessEmptyMatches

	override fun toKotlinRegex(): Regex {
		return matchRegex
	}

	override fun canToRegex(): Boolean {
		return true
	}

	override fun useOn(string: String): Matches {
		val matches = ArrayList<Match>()
		
		matchRegex.findAll(string).forEach {
			//println(": " + it.value + " " + it.range.start + " " + it.range.end)
			matches.add(Match(it.value, it.range.start, it.range.end + 1))
		}

		if (removeExcessEmptyMatches) matches.asReversed().forEach { 
			if (it != matches.first() && it.string == "") {
				matches.remove(it);
			}
		}
		
		return Matches(matches)
	}
}
