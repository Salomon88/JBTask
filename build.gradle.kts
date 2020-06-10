group = "org.jetbrains"
version = "1.0"

repositories {
    mavenCentral()
}

plugins {
    kotlin("jvm") version "1.3.61"
    antlr
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(group = "org.antlr", name = "antlr4-runtime", version = "4.7.2")
    antlr("org.antlr:antlr4:4.7.2")
    testImplementation("junit:junit:4.12")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    generateGrammarSource {
        arguments = arguments + listOf(
            "-no-listener",
            "-visitor",
            "-package",
            "org.jetbrains.calculator.antlr",
            "-Xexact-output-dir"
        )
    }
}
