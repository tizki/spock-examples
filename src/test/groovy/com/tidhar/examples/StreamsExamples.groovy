package com.tidhar.examples

import groovy.json.JsonBuilder
import groovy.json.JsonSlurper
import spock.lang.Specification

import java.util.function.Predicate

class StreamsExamples extends Specification{


    def "get id from response using optional"(){

        setup:
        FakeResponse response = getFakeResponse()

        when:
        def map = Optional.of(response)
                filter(r -> r.getBody())

        then:
        map != null
    }

    static class FakeResponse{

        private Map body

        FakeResponse(Map body) {
            this.body = body
        }

        public Map getBody() {
            return body
        }
    }

    private static String getJsonResponse(){
        def jsonSlurper = new JsonSlurper()
        return jsonSlurper.parseText('{ "id": "123456" } ').toString()
    }

    private static FakeResponse getFakeResponse(){
        FakeResponse fakeResponse = new FakeResponse(["id" :"12345"])
        return fakeResponse

    }
}
