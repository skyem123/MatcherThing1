package uk.co.skyem.random.regexreplace1

/**
 * An exact matcher matches a string exactly, no regex, etc...
 */
public class ExactMatcher(matches: String) : Matcher {
    val matchString = matches;

    override fun useOn(string: String) {
        // Loop through the string until this is found in the string
        //string.findAnyOf(setOf(matchString), )
        throw UnsupportedOperationException()
    }
}