/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package com.tidhar.examples

import groovy.json.JsonSlurper

class HelloWorld {

    String sayHello(){
        return "Hello, world"
    }

    String sayHello(String username){
        return "Hello, ${username}"
    }

    static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld()
        println(helloWorld.sayHello())

        FakeResponse fakeResponse = getFakeResponse()
        def optional = Optional.ofNullable(fakeResponse)
                .filter(r -> !r.getBody().isEmpty())
                .filter(r -> r.getBody()["id"] != "")
        .map(r -> r.getBody()["id"])

        println(optional.isPresent())
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

    private static FakeResponse getFakeResponse(){
        FakeResponse fakeResponse = new FakeResponse([:])
//        FakeResponse fakeResponse = new FakeResponse(["id" :"12345"])
        return fakeResponse
    }
}
