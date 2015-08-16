How to use the string matcher
=============================
This assumes that you have managed to get the string matcher classes loaded somehow.

There is a Matcher class that is the base class for all other matchers, and to create marchers, you need to use the functions provided in MatcherFunctions, and to use the functions easily, you can use
```Java
import static uk.co.skyem.random.stringMatcher1.MatcherFunctions; // To use the matcher functions
import uk.co.skyem.ramdom.stringMatcher1.*; // To use the Matcher, Match, and Matches classes
```
Once the functions are statically imported, you can use them to create your matcher objects.

The most basic type of matcher is the exact matcher, with the simple function ```matcher(String)```, it matches only when the string given to it is found.
To use all matcher, their ```.useOn(String)``` method must be called.

The ```.useOn(String)``` runs the matcher on the string given, returning a collection of ```Match``` objects.
This collection is called ```Matches```, and has some methods for convenience, for example, the ```.first()``` and ```.last()``` method, which return the first and last match respectively.
```Java
Matches matches = matcher("hello").useOn("hello world");
System.out.println(matches.first()); // gets the first match found, which is this case, is "hello", with the start position 0, and the end position of 6.
```

Some other matchers, for example the ```startsWith(Matcher)``` matcher, accepts another matcher to start matching from.

#### A listing and explanation of what the matchers do
* ```match(String)``` matches the string given to it.
* ```matchInsensitive(String)``` does a case insensitive match of the string given to it.
* ```matchAll()``` matches everything.
* ```startsWith(Matcher)``` matches everything starting with the matcher given, uses the first result of the matcher given to start matching from.
* ```startsWithExc(Matcher)``` matches everything starting with the matcher given, but not including the match, uses the end position of the first result of the matcher given to start matching from
* ```endsWith(Matcher)``` matches everything ending with the matcher given, from the start of the input (from ```.useOn(String)```) to the end of the last match from the matcher given.
* ```endsWithExc(Matcher)``` matches everything ending with the matcher given, from the start of the input (from ```.useOn(String)```) to the start of the last match from the matcher given.
* ```regexMatcher(Regex)``` matches the regular expression given, either as a String, a java.util.regex pattern, or a kotlin.text.Regex.
* ```regexMatcher(RegexString, Flags)``` matches the regular expression given as a String. Flags can either be an integer, with the java.util.regex pattern flags format, or a single kotlin.text.RegexOption or a set of multiple kotlin.text.RegexOption.
* ```matchAllIf(Matcher)``` is a strange one, it matches the whole input (from ```.useOn(String)```) if the matcher given matches anything from the input.
* ```matchAllIfExc(Matcher)``` is another strange one, it matches the whole input (from ```.useOn(String)```), **excluding** things that are matched by the matcher given, only if the matcher given matches anything from the input,

#### A listing of what the methods on the matchers do
* ```.useOn(String)``` simply put, uses the matcher on the string given. This method returns a collection of ```Match``` objects, in a ```Matches``` collection.
* ```.invert()``` returns an inverted matcher that does the inverse of the original matcher, so things that it matched are not matched by the new matcher, and things that it didn't match are matched by the new matcher.
* ```.canToRegex()``` is used to check if a matcher can be turned into a regex, so you can avoid having to catch exceptions thrown by other methods that convert this matcher to a regex.
* ```.toKotlinRegex()``` converts the matcher to a kotlin.text.Regex. It can throw an ```UnsupportedOperationException``` if it cannot convert the matcher to a Regex.
* ```.toRegexPattern()``` converts the matcher to a java.util.regex.Pattern, it can throw an ```UnsupportedOperationException``` if it cannot convert the matcher to a Regex.
* ```.toRegexString()``` converts the matcher to a string containing the regex. This excludes flags and can throw an ```UnsupportedOperationException``` if it cannot convert the matcher to a Regex.

#### How to use the Matches object
The matches object has a ```.get(Integer)``` to get a match.
For convenience, it also has a ```.first()``` method to get the first match found, and a ```.last()``` method to get the last match found.

#### How to use a Match object
* a match equals other match if it has the same start, position, end position and string.
* to get the values stored in a match, you use ```.getStart()```, ```.getEnd()``` and ```.getString()```.