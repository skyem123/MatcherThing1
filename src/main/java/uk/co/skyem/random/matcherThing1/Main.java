package uk.co.skyem.random.matcherThing1;

import static uk.co.skyem.random.matcherThing1.MatcherFunctions.*;

public class Main {
    public static void main(String[] args) {

        ExactMatcher test1 = match("test");
        System.out.println(test1.getMatchString());
        String toTest1 = "This is a test";
        Match match1 = test1.useOn(toTest1).first();
        System.out.println(toTest1 + "\n" + match1.getStart() + " " + match1.getEnd() + " " + match1.getString());
        // matchExact("test").useOn("This is a test").first();

        System.out.println();

        RegexMatcher test2 = matchRegex("'.*'");
        System.out.println(test2.getMatchRegex());
        String toTest2 = "This is a 'test'";
        Match match2 = test2.useOn(toTest2).first();
        System.out.println(toTest2 + "\n" + match2.getStart() + " " + match2.getEnd() + " " + match2.getString());
        // matchExact("'.*").useOn("This is a 'test'").first();

        System.out.println();

        //ExactMatcher test3 = matchInsensitive("test");
        RegexMatcher test3 = matchInsensitive("test");
        System.out.println(test1.getMatchString());
        String toTest3 = "This is a Test";
        System.out.println(test3.getMatchRegex());
        Match match3 = test3.useOn(toTest3).first();
        System.out.println(toTest3 + "\n" + match3.getStart() + " " + match3.getEnd() + " " + match3.getString());
        // matchInsensitive("test").useOn("This is a Test").first();
    }
}
