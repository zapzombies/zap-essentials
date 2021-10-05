import io.github.zap.build.gradle.convention.paperApi
import io.github.zap.build.gradle.convention.publishToZGpr
import io.github.zap.build.gradle.convention.zgpr

// Uncomment to use local maven version - help local testing faster
plugins {
    // id("io.github.zap.build.gradle.convention.shadow-mc-plugin") version "0.0.0-SNAPSHOT"
    id("io.github.zap.build.gradle.convention.shadow-mc-plugin") version "1.0.0"
}

repositories {
    maven(zgpr("zap-commons"))
}

dependencies {
    paperApi("1.16.5-R0.1-SNAPSHOT")
    compileOnlyApi("io.github.zap:zap-commons:1.1.0")
}

publishToZGpr()
