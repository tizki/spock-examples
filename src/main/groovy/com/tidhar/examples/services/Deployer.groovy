package com.tidhar.examples.services

import com.tidhar.examples.notifiers.Notifier

class Deployer {

    Notifier notifier;

    Deployer(Notifier notifier) {
        this.notifier = notifier
    }

    void deploy(String serviceName){
        println("Deploying...")
        if(serviceName?.trim()){
            notifier.notifySuccessWithMessage("Deployed ${serviceName}")
        } else{
            notifier.notifyFailureWithMessage("To deploy service with name: ${serviceName}")
        }
    }
}
