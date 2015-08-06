package uk.co.skyem.random.matcherThing1;

public class Main {
    public static void main(String[] args) {
        ExactMatcher test = new ExactMatcher("test");
        System.out.println(test.getMatchString());
        String toTest = "This is a test";
        Match match = test.useOn("This is a test").first();
        System.out.println(toTest + "\n" + match.getStart() + " " + match.getEnd() + " " + match.getString());
    }
}
