package uk.co.skyem.random.stringMatcher1

import kotlin.platform.platformStatic
import kotlin.text.RegexOption

public interface Matcher {
	fun canToRegex(): Boolean

	fun useOn(string: String): Matches

	fun invert(): Inverter {
		return Inverter(this)
	}

	override fun equals(other: Any?): Boolean
}
