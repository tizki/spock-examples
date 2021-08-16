package com.tidhar.examples

import spock.lang.Specification

class CalculatorTest extends Specification {

    def "Add one case"() {

        setup:
        int expectedSum = 8

        when:
        int sum = Calculator.add(3, 5)

        then:
        expectedSum == sum
    }

    def "Add multi cases - data driven"(int x, int y, int result) {

        expect:
        x + y == result

        where:
        x |  y | result
        0 |  0 | 0
        1 |  2 | 3
        1 |  -1 | 0
        100 |  123 | 223
    }
}
