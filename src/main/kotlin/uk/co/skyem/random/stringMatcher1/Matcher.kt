package uk.co.skyem.random.stringMatcher1

import java.util.regex.Pattern
import kotlin.text.Regex
import kotlin.text.RegexOption

internal interface Matcher {
	override fun equals(other: Any?): Boolean
	/**
	 * Use to check if this matcher can be turned into a RegEx to avoid exceptions.
	 *
	 * @return ```true``` if this matcher can be turned into a RegEx. returns ```false``` if not.
	 */
	fun canToRegex(): Boolean

	/**
	 * Uses this [Matcher] object on a [kotlin.String].
	 *
	 * @param string The string to perform matching on.
	 * @return a [Matches] collection of [Match] objects.
	 */
	fun useOn(string: String): Matches

	/**
	 * Inverts this [Matcher].
	 * When the inverted matcher is used, it will match all things not matched by the original matcher, and things matched by the original matcher are not matched.
	 *
	 * @return an inverted [Matcher] that matches everything not matched by this one, and doesn't match things matched by this one.
	 */
	fun invert(): Matcher {
		return Inverter(this)
	}

	/**
	 * Converts this matcher into a RegEx, [kotlin.String] format.
	 *
	 * @throws UnsupportedOperationException if it cannot be converted into a RegEx.
	 * @return a string with the RegEx
	 */
	fun toRegexString(): String {
		return toKotlinRegex().pattern
	}

	/**
	 * Converts this matcher into a RegEx, [kotlin.text.Regex] format.
	 *
	 * @throws UnsupportedOperationException if it cannot be converted into a RegEx.
	 * @return a [kotlin.text.Regex] with the RegEx.
	 */
	fun toKotlinRegex(): Regex {
		throw UnsupportedOperationException("Cannot convert this Matcher to regex");
	}

	/**
	 * Converts this matcher into a RegEx, [java.util.regex.Pattern] format.
	 *
	 * @throws UnsupportedOperationException if it cannot be converted into a RegEx.
	 * @return a [java.util.regex.Pattern] of the RegEx.
	*/
	fun toRegexPattern(): Pattern {
		return toKotlinRegex().toPattern()
	}
}
