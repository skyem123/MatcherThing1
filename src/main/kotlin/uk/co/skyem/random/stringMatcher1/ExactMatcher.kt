package uk.co.skyem.random.stringMatcher1

import kotlin.text.Regex

/**
 * An exact matcher matches a string exactly, no regex, etc...
 */
internal class ExactMatcher(matches: String, caseInsensitive: Boolean) :
		RegexMatcher(if (caseInsensitive) "(?i)" + Regex.escape(matches) else Regex.escape(matches)) {
	constructor(matches: String): this(matches, false)

	val matchString = matches
	val caseInsensitive = caseInsensitive
}
