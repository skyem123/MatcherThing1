package uk.co.skyem.random.stringMatcher1

import java.util.regex.Pattern
import kotlin.platform.platformStatic
import kotlin.text.Regex
import kotlin.text.RegexOption

public interface Matcher {
	fun canToRegex(): Boolean

	fun useOn(string: String): Matches

	fun invert(): Inverter {
		return Inverter(this)
	}

	override fun equals(other: Any?): Boolean

	fun toRegexString(): String {
		return toKotlinRegex().pattern
	}
	fun toKotlinRegex(): Regex {
		throw UnsupportedOperationException("Cannot convert this Matcher to regex");
	}
	fun toRegexPattern(): Pattern {
		return toKotlinRegex().toPattern()
	}
}
