plugins {
    kotlin("jvm") version "1.9.23" // Use your Kotlin version
    // Add this serialization plugin
    kotlin("plugin.serialization") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Add this dependency for JSON serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
}
