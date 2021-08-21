package com.tidhar.examples

import java.util.regex.Matcher
import java.util.regex.Pattern

class RegexExamples {

    static boolean contains(String container, String contained){
        if(container =~ contained){
            return true
        }
        return false
    }

    static Pattern stringToPattern(String string){
        return ~string
    }

    static List<String> getOccurrencesOfPattern(String string, String pattern){
        Matcher matcher = string =~ pattern
        return matcher[0..-1]
    }

    static boolean isExactPattern(String string, String pattern){
        return string ==~ pattern
    }
}
