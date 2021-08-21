package com.tidhar.examples

import spock.lang.Specification

import java.util.regex.Pattern

class RegexExamplesTest extends Specification {


    def "Test string contains expression using =~ operator"(String container, String containedExpression, boolean doesContain) {

        expect:
        RegexExamples.contains(container, containedExpression) == doesContain

        where:
        container | containedExpression | doesContain
        "Groovy regex" | /Groovy/ | true
        "Groovy regex" | /groovy/ | false
        "Groovy regex" | "groovy" | false
        "peter.parker@yopmail.com" | /\w+[\.]?\w+@\w+\w+/ | true
        "peter1.parker@yopmail.com" | /\w+[\.]?\w+@\w+\w+/ | true
    }

    def "Test String to Pattern conversions using ~ operator"(String string, Pattern expectedPattern){

        expect:
        RegexExamples.stringToPattern(string).class == Pattern.class
        RegexExamples.stringToPattern(string).toString() == expectedPattern.toString()

        where:
        string | expectedPattern
        "groovy" | Pattern.compile("groovy")
        "\\w+[.]?\\w+@\\w+\\w+" | Pattern.compile("\\w+[.]?\\w+@\\w+\\w+")
    }

    def "find all email addresses in string using =~ and matcher[0..-1]"(){

        setup:
        String str = """this is an email from peter.parker@avengers.com to
tony.stark@avengers.com"""
        List<String> expectedEmails = ["peter.parker@avengers.com", "tony.stark@avengers.com"]

        when:
        List<String> results = RegexExamples.getOccurrencesOfPattern(str, "\\w+[.]?\\w+@\\w+[.]\\w+")

        then:
        expectedEmails == results
    }


    def "check if a string is exact pattern using ==~"(String string, String pattern, boolean isExact){

        expect:
        RegexExamples.isExactPattern(string, pattern) == isExact

        where:
        string                      | pattern                       | isExact
        "peter.parker@avengers.com" | "peter.parker@avengers.com"   | true
        "peter.parker@avengers.com" | "\\w+.\\w+@avengers.com"      | true
        "peter.parker@avengers.com" | "\\w+.\\w+@hydra.com"         | false
        "peter.parker@avengers.com" | '\\w+.\\w+@\\w+.\\w+'         | true
        "peter.parker@avengers.com" | '[a-zA-z]+.\\w+@\\w+.\\w+'    | true
    }

}
