import java.util.Locale

pluginManagement {
    includeBuild("plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "kmisskey"

include("core")
include("stream")
include("all")


// exclude "all" on Windows OS
val osName = System.getProperty("os.name").lowercase(Locale.getDefault())
if (osName.contains("mac")) {
    include("all")
}

plugins {
    // To obtain an appropriate JVM environment in CI environments, etc.
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}