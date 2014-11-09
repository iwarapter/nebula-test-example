package com.iadams.gradle.plugins.example

import nebula.test.IntegrationSpec
import nebula.test.functional.ExecutionResult
import spock.lang.Ignore

class ExamplePluginIntegSpec extends IntegrationSpec {

    def 'setup new build and call example'() {
        setup:
            writeHelloWorld('com.iadams')
            buildFile << '''
                        apply plugin: 'com.iadams.example'
                    '''.stripIndent()


        when:
            ExecutionResult result = runTasksSuccessfully('example')

        then:
            result.standardOutput.contains('HelloWorld.java')
    }

    def 'setup new build and call example again'() {
        setup:
            writeHelloWorld('com.iadams')
            buildFile << '''
                        apply plugin: 'com.iadams.example'
                    '''.stripIndent()


        when:
            ExecutionResult result = runTasksSuccessfully('example')

        then:
            result.standardOutput.contains('HelloWorld.java')
    }
}
