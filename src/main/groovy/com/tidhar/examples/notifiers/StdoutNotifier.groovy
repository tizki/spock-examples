package com.tidhar.examples.notifiers

class StdoutNotifier implements Notifier {


    @Override
    void notifySuccess() {
        println("Success")
    }

    @Override
    void notifySuccessWithMessage(String message) {
        println("Success ${message}")
    }

    @Override
    void notifyFailure() {
        println("Failed")
    }

    @Override
    void notifyFailureWithMessage(String message) {
        println("Failed ${message}")
    }
}
