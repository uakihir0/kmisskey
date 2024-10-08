plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.serialization)
    id("maven-publish")
}

kotlin {
    jvmToolchain(11)

    jvm { withJava() }
    js(IR) {
        nodejs()
        browser()
        binaries.library()
        generateTypeScriptDefinitions()
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }

        commonMain.dependencies {
            implementation(libs.ktor.core)
            implementation(libs.kmpcommon)
            implementation(libs.khttpclient)
            implementation(libs.datetime)
            implementation(libs.serialization.json)

            implementation(project.dependencies.platform("org.kotlincrypto.hash:bom:0.5.3"))
            implementation("org.kotlincrypto.hash:md")
            implementation("org.kotlincrypto.hash:sha1")
            implementation("org.kotlincrypto.hash:sha2")
        }

        // for test (kotlin/jvm)
        jvmTest.dependencies {
            implementation(kotlin("test"))
            implementation(libs.kotest.junit5)
            implementation(libs.kotest.assertions)
        }
    }
}


tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
}

publishing {
    repositories {
        maven {
            url = uri("https://repo.repsy.io/mvn/uakihir0/public")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("PASSWORD")
            }
        }
    }
}