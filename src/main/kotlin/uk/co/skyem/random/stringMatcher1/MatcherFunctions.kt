package uk.co.skyem.random.stringMatcher1

import java.util.regex.Pattern
import kotlin.text.Regex
import kotlin.text.RegexOption

public object MatcherFunctions {
	/**
	 * Match a string exactly.
	 *
	 * @param toMatch the string to match.
	 * @return a [Matcher] object that matches the string given to the function exactly.
	 */
	public @JvmStatic fun match(toMatch: String): Matcher {
		return ExactMatcher(toMatch)
	}
	/**
	 * Matches a string with case insensitivity.
	 *
	 * @param toMatch the string to match.
	 * @return a [Matcher] object that matches the string given with case insensitivity.
	 */
	public @JvmStatic fun matchInsensitive(toMatch: String): Matcher {
		return ExactMatcher(toMatch, true)
	}

	/**
	 * Matches a regular expression (RegRx).
	 *
	 * @param pattern The RegEx pattern in [kotlin.String] format.
	 * @return a [Matcher] object that matches the RegEx given.
	 */
	public @JvmStatic fun matchRegex(pattern: String): Matcher {
		return RegexMatcher(pattern)
	}
	/**
	 * Matches a regular expression (RegRx).
	 *
	 * @param pattern The RegEx pattern in [kotlin.String] format.
	 * @param flags The RegEx flags as a [kotlin.Int], with the flags from [java.util.regex.Pattern]
	 * @return a [Matcher] object that matches the RegEx given.
	 */
	public @JvmStatic fun matchRegex(pattern: String, flags: Int): Matcher {
		return RegexMatcher(pattern, flags)
	}
	/**
	 * Matches a regular expression (RegRx).
	 *
	 * @param pattern The RegEx pattern in [kotlin.String] format.
	 * @param flag a [kotlin.text.RegexOption] that controls the RegEx.
	 * @return a [Matcher] object that matches the RegEx given.
	 */
	public @JvmStatic fun matchRegex(pattern: String, flag: RegexOption): Matcher {
		return RegexMatcher(pattern, flag)
	}
	/**
	 * Matches a regular expression (RegRx).
	 *
	 * @param pattern The RegEx pattern in [kotlin.String] format.
	 * @param flags a [kotlin.Set] of [kotlin.text.RegexOption]s that control the RegEx.
	 * @return a [Matcher] object that matches the RegEx given.
	 */
	public @JvmStatic fun matchRegex(pattern: String, flags: Set<RegexOption>): Matcher {
		return RegexMatcher(pattern, flags)
	}
	/**
	 * Matches a regular expression (RegRx).
	 *
	 * @param pattern The RegEx pattern in [java.util.regex.Pattern] format.
	 * @return a [Matcher] object that matches the RegEx given.
	 */
	public @JvmStatic fun matchRegex(pattern: Pattern): Matcher {
		return RegexMatcher(pattern)
	}
	/**
	 * Matches a regular expression (RegRx).
	 *
	 * @param pattern The RegEx pattern in [kotlin.text.Regex] format.
	 * @return a [Matcher] object that matches the RegEx given.
	 */
	public @JvmStatic fun matchRegex(pattern: Regex): Matcher {
		return RegexMatcher(pattern)
	}

	/**
	 * Matches everything.
	 *
	 * @return a [Matcher] object that matches everything.
	 */
	public @JvmStatic fun matchAll(): Matcher {
		return EverythingMatcher()
	}

	/**
	 * Matches everything from and including the first match from the [Matcher] given.
	 *
	 * @param matcher The matcher to start matching from.
	 * @return a [Matcher] object that matches everything from and including the first match from the [Matcher] given.
	 */
	public @JvmStatic fun startsWith(matcher: Matcher): Matcher {
		return StartEndMatcher(matcher, true, false, false)
	}
	/**
	 * Matches up to and including the last match from the [Matcher] given.
	 *
	 * @param matcher The matcher to match until.
	 * @return a [Matcher] object that matches everything up to and including the last match from the [Matcher] given.
	 */
	public @JvmStatic fun endsWith(matcher: Matcher): Matcher {
		return StartEndMatcher(matcher, false, true, false)
	}

	/**
	 * Matches everything if the [Matcher] given matches anything.
	 *
	 * @param matcher the [Matcher] to check.
	 * @return a [Matcher] object that matches everything if the matcher given matches anything.
	 */
	// Well... this is an interesting side effect!
	public @JvmStatic fun matchAllIf(matcher: Matcher): Matcher {
		return StartEndMatcher(matcher, true, true, false)
	}

	/**
	 * Matches everything from, but excluding the first match from the [Matcher] given.
	 *
	 * @param matcher The matcher to start matching from.
	 * @return a [Matcher] object that matches everything from, but excluding the first match from the [Matcher] given.
	 */
	public @JvmStatic fun startsWithExc(matcher: Matcher): Matcher {
		return StartEndMatcher(matcher, true, false, true)
	}
	/**
	 * Matches up to, but including the last match from the [Matcher] given.
	 *
	 * @param matcher The matcher to match until.
	 * @return a [Matcher] object that matches everything up to from, but excluding the last match from the [Matcher] given.
	 */
	public @JvmStatic fun endsWithExc(matcher: Matcher): Matcher {
		return StartEndMatcher(matcher, false, true, true)
	}
	/**
	 * Matches everything if the [Matcher] given matches anything, excluding things matched by the matcher given.
	 *
	 * @param matcher the [Matcher] to check.
	 * @return a [Matcher] object that matches everything if the matcher given matches anything, excluding what the matcher given matches.
	 */
	// Well... this is a nice side effect!
	public @JvmStatic fun matchAllIfExc(matcher: Matcher): Matcher {
		return StartEndMatcher(matcher, true, true, true)
	}
}
