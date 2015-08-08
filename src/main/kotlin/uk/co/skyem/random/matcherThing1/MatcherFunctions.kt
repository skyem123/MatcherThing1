package uk.co.skyem.random.matcherThing1

import java.util.regex.Pattern
import kotlin.platform.platformStatic
import kotlin.text.Regex
import kotlin.text.RegexOption

public object MatcherFunctions {
    public platformStatic fun match(toMatch: String): ExactMatcher {
        return ExactMatcher(toMatch)
    }
    public platformStatic fun matchInsensitive(toMatch: String): ExactMatcher {
        return ExactMatcher(toMatch, true)
    }

    public platformStatic fun matchRegex(pattern: String): RegexMatcher {
        return RegexMatcher(pattern)
    }
    public platformStatic fun matchRegex(pattern: String, flags: Int): RegexMatcher {
        return RegexMatcher(pattern, flags)
    }
    public platformStatic fun matchRegex(pattern: String, flag: RegexOption): RegexMatcher {
        return RegexMatcher(pattern, flag)
    }
    public platformStatic fun matchRegex(pattern: String, flags: Set<RegexOption>): RegexMatcher {
        return RegexMatcher(pattern, flags)
    }
    public platformStatic fun matchRegex(pattern: Pattern): RegexMatcher {
        return RegexMatcher(pattern)
    }
    public platformStatic fun matchRegex(pattern: Regex): RegexMatcher {
        return RegexMatcher(pattern)
    }

    public platformStatic fun matchAll(): EverythingMatcher {
        return EverythingMatcher()
    }

    public platformStatic fun startsWith(matcher: Matcher): StartEndMatcher {
        return StartEndMatcher(matcher, true, false)
    }
    public platformStatic fun endsWith(matcher: Matcher): StartEndMatcher {
        return StartEndMatcher(matcher, false, true)
    }
    public platformStatic fun matchAllIf(matcher: Matcher): StartEndMatcher {
        return StartEndMatcher(matcher, true, true)
    }
    /*
    public platformStatic fun seNop(matcher: Matcher): StartEndMatcher {
        return StartEndMatcher(matcher, true, false)
    }
    */
}
