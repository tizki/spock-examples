package com.tidhar.examples

import spock.lang.Specification

class StringManipulationTest extends Specification{

    def "concat 2 string using '+' operator"(){

        setup:
        String firstString = "Hello, "
        String secondString = "world"
        String expectedResult = "Hello, world"

        when:
        String result = firstString + secondString

        then:
        expectedResult == result
    }

    def "substring using '-' operator"(){

        setup:
        String firstString = "Hello, world"
        String secondString = "world"
        String expectedResult = "Hello, "

        when:
        String result = firstString - secondString

        then:
        expectedResult == result
    }

    def "substring using [n..m]"(String original, String result, int fromIndex, int toIndex){

        expect:
        result == original[fromIndex..toIndex]

        where:
        original | fromIndex | toIndex | result
        "Hello, world" | 0   |    4    | "Hello"
        "Hello, world" | 7   |    11    | "world"
    }

    def "substring using 'take'"(String original, String result, int amountToTake){

        expect:
        result == original.take(amountToTake)

        where:
        original |  amountToTake | result
        "Hello, world" |    5    | "Hello"
        "Hello, world" |    0    | ""
        "Hello, world" |    12    | original
    }

    def "repeat string"(){

        setup:
        String original = "a"
        String expected = "aaaaaaaaaa"

        when:
        String result = original*10

        then:
        expected == result
    }
}
