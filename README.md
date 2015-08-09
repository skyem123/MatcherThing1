# StringMatcher1
A string matching thing written in Kotlin, because RegEx is too painful on it's own. (and I wanted to try Kotlin).

## Why?
### _Because Regular Expressions are too painful on their own._
Seriously though, I have had a lot of trouble using regex that has actually made me _cry_, so I really want to make something to replace it.
Currently, this is just a stupid idea and very limited, but... It is slightly usable.

## How do I use it?
This is currently vague, because I might change stuff in the future, but the general idea is that you import the Class containing the functions that return matchers.
To acutally be able to use it easilly, use ```import static```. For example, just use this import line:
```Java
import static uk.co.skyem.random.stringMatcher1.MatcherFunctions;
```

Then just start matching things!
```Java
match("Hello").useOn("Hello, World");
```
Will return a ```Matches``` object, with a single ```Match``` object inside that contains the match (in this case, the string ```"Hello"```, the start position of the match and the end position of the match).
And to match everything up to and incuding another match, use
```Java
leftOf(match("Hello"))
```
