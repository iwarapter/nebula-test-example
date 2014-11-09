package com.iadams.gradle.plugins.example.extensions

import org.gradle.api.Project

class ExamplePluginExtension {

    String sourceDir
    String destDir
    String includes = '**/*'
    String exclusions = ''
    
    ExamplePluginExtension( Project project) {
        sourceDir = new File("${project.projectDir}/src/main/java")
        destDir = new File("${project.buildDir}/example")
    }
}