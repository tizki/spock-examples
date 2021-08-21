package com.tidhar.examples.notifiers

interface Notifier {

    void notifySuccess()

    void notifySuccessWithMessage(String message)

    void notifyFailure()

    void notifyFailureWithMessage(String message)
}
