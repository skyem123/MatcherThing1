package uk.co.skyem.random.stringMatcher1;

import junit.framework.TestCase;

import static org.assertj.core.api.Assertions.*;

import static uk.co.skyem.random.stringMatcher1.MatcherFunctions.*;

public class MatcherTests extends TestCase {
    // These are here so I can reuse them without manualy copying them!
    // DO NOT CHANGE!
    public final String testString1 = "this is a test of my thing";
    /*   0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25
       | t | h | i | s |   | i | s |   | a |   | t | e | s | t |   | o | f |   | m | y |   | t | h | i | n | g |
       0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26
       */
    public final String matchString1 = "test";
    /*
        "  t   e   s   t  "
         | t | e | s | t |
         | 0 | 1 | 2 | 3 |
         0   1   2   3   4

        Bottom line is where substring "slices" a string.
        This is also how my system works.h
     */
    public final String testString2 = "this, is a test!\\E\\Q ... :D";
    public final String matchString2 = "!\\E\\Q ... :D";


    public void testSimpleMatch() throws Exception {
        Matches matches = match(matchString1).useOn(testString1);
        // matches should contain only one match
        assertThat(matches).containsOnly(
                new Match(matchString1, 10, 14)
        );
        System.out.println("simple match passed.");
    }

    public void testSimpleMatchWithSpecialChars() throws Exception {
        Matches matches = match(matchString2).useOn(testString2);
        // matches should contain only one match
        assertThat(matches).containsOnly(
                    new Match(matchString2, 15, 27)
        );
        System.out.println("simple match with special characters passed.");
    }

    public void testInsensitiveMatch() throws Exception {
        Matches matches = matchInsensitive(matchString1.toUpperCase()).useOn(testString1);
        // matches should contain only one match
        assertThat(matches).containsOnly(
                new Match(matchString1, 10, 14)
        );
        System.out.println("case insensitive simple match passed.");
    }

    public void testEverythingMatcher() throws Exception {
        Matches matches = matchAll().useOn(testString1);
        // matches should contain only one match
        assertThat(matches).containsOnly(
                new Match(testString1, 0, testString1.length())
        );
        System.out.println("global match passed.");
    }
}