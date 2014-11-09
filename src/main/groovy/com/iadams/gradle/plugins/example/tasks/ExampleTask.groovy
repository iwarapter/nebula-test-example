package com.iadams.gradle.plugins.example.tasks

import static groovy.io.FileType.FILES
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.*
import org.gradle.api.logging.LogLevel

class ExampleTask extends DefaultTask {

    @InputDirectory
    File sourceDir

    @Input
    @Optional
    String includes

    @Input
    @Optional
    String exclusions

    @OutputDirectory
    File destDir


    @TaskAction
    void runExample() {

        logger.debug "SourceDir ${getSourceDir()}"
        logger.debug "Includes: ${getIncludes()}"
        logger.debug "Exclusions: ${getExclusions()}"
        logger.debug "DestDir ${getDestDir()}"

        def inputFiles = new FileNameFinder().getFileNames(getSourceDir().toString(),getIncludes(),getExclusions())
        inputFiles.each{ logger.info it }
    }
}