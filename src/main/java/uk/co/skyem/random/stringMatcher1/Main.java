package uk.co.skyem.random.stringMatcher1;

import static uk.co.skyem.random.stringMatcher1.MatcherFunctions.*;

class Main {
    public static void main(String[] args) {
        RegexMatcher test2 = matchRegex("'.*'");
        System.out.println(test2.getMatchRegex());
        String toTest2 = "This is a 'test'";
        Match match2 = test2.useOn(toTest2).first();
        System.out.println(toTest2 + "\n" + match2.getStart() + " " + match2.getEnd() + " " + match2.getString());
        // matchExact("'.*").useOn("This is a 'test'").first();

        System.out.println();

        EverythingMatcher test4 = matchAll();
        System.out.println(test4.getMatchRegex());
        String toTest4 = "this is a test";
        Match match4 = test4.useOn(toTest4).first();
        System.out.println(toTest4 + "\n" + match4.getStart() + " " + match4.getEnd() + " " + match4.getString());
        // matchAll().useOn("This is a test").first();

        System.out.println();
        System.out.println();

        StartEndMatcher seMatcher1 = matchAllIf(match("test"));
        System.out.println(seMatcher1.toRegexString());
        System.out.println(seMatcher1.useOn("this is my thingy").matchFound());

        System.out.println();

        StartEndMatcher seMatcher2 = matchAllIf(match("test"));
        System.out.println(seMatcher2.toRegexString());
        Matches seMatches2 = seMatcher2.useOn("this is my a test of my thingy");
        System.out.println(seMatches2.first().getString() + " " + seMatches2.first().getStart() + " " + seMatches2.first().getEnd());

        System.out.println();

        // this has no shorthand function, as it is a NOP.
        StartEndMatcher seMatcher3 = new StartEndMatcher(match("test"), false, false, false);
        System.out.println(seMatcher3.toRegexString());
        Matches seMatches3 = seMatcher3.useOn("this is my a test of my thingy");
        System.out.println(seMatches3.first().getString() + " " + seMatches3.first().getStart() + " " + seMatches3.first().getEnd());
        
        System.out.println();

        StartEndMatcher seMatcher4 = startsWith(match("test"));
        System.out.println(seMatcher4.toRegexString());
        Matches seMatches4 = seMatcher4.useOn("this is my a test of my thingy");
        System.out.println(seMatches4.first().getString() + " " + seMatches4.first().getStart() + " " + seMatches4.first().getEnd());

        System.out.println();

        StartEndMatcher seMatcher5 = endsWith(match("test"));
        System.out.println(seMatcher5.toRegexString());
        Matches seMatches5 = seMatcher5.useOn("this is my a test of my thingy");
        System.out.println(seMatches5.first().getString() + " " + seMatches5.first().getStart() + " " + seMatches5.first().getEnd());

        System.out.println();

        Inverter inverter = match("test").invert();
        Matches invertMatches = inverter.useOn("this is a test of my thing");
        for (Match match : invertMatches) {
            System.out.println(match.getString() + " " + match.getStart() + " " + match.getEnd());
        }


    }
}
