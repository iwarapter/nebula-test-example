package com.iadams.gradle.plugins.example

import com.iadams.gradle.plugins.example.extensions.ExamplePluginExtension
import com.iadams.gradle.plugins.example.tasks.ExampleTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin

class ExamplePlugin implements Plugin<Project> {
    static final EXAMPLE_EXTENSION = 'example'
    static final EXAMPLE_TASK = 'example'

    @Override
    void apply(Project project) {

        project.plugins.apply(BasePlugin.class)

        project.extensions.create( EXAMPLE_EXTENSION, ExamplePluginExtension, project )

        addTasks(project)
    }

    void addTasks( Project project ) {
        def extension = project.extensions.findByName(EXAMPLE_EXTENSION)

        project.task( EXAMPLE_TASK, type: ExampleTask) {
            description = 'Example.'
            group = 'Example'

            conventionMapping.sourceDir = { new File(extension.sourceDir) }
            conventionMapping.includes = { extension.includes }
            conventionMapping.exclusions = { extension.exclusions }
            conventionMapping.destDir = { new File(extension.destDir) }
        }
    }
}
