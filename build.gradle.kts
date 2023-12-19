import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("fabric-loom") version "1.3.8"
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
    id("org.teamvoided.iridium") version "3.1.9"
}

group = project.properties["maven_group"]!!
version = project.properties["mod_version"]!!
base.archivesName.set(project.properties["archives_base_name"] as String)
description = "TeamVoided Template"
val modid = project.properties["modid"]!! as String

repositories {
    mavenCentral()
}

modSettings {
    modId(modid)
    modName("Team Voided Template")

    entrypoint("main", "org.teamvoided.theabyss.Abyss::commonInit")
    entrypoint("client", "org.teamvoided.theabyss.Abyss::clientInit")

    mixinFile("the-abyss.mixins.json")
}

tasks {
    val targetJavaVersion = 17
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        options.release.set(targetJavaVersion)
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = targetJavaVersion.toString()
    }

    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(JavaVersion.toVersion(targetJavaVersion).toString()))
        withSourcesJar()
    }
}