package com.tidhar.examples.services

import com.tidhar.examples.notifiers.Notifier
import spock.lang.Specification

class DeployerTest extends Specification {

    Notifier notifier = GroovyMock(Notifier.class)

    def "Deploy successful"() {
        setup:
        Deployer deployer = new Deployer(notifier)

        when:
        deployer.deploy("banking")

        then:
        1 * notifier.notifySuccessWithMessage("Deployed banking")
    }

    def "Deploy failed for empty string"() {
        setup:
        Deployer deployer = new Deployer(notifier)

        when:
        deployer.deploy("")

        then:
        1 * notifier.notifyFailureWithMessage("To deploy service with name: ")
    }

    def "Deploy failed for null string"() {
        setup:
        Deployer deployer = new Deployer(notifier)

        when:
        deployer.deploy(null)

        then:
        1 * notifier.notifyFailureWithMessage("To deploy service with name: ")
    }
}
