import io.github.zap.build.gradle.convention.paperApi
import io.github.zap.build.gradle.convention.publishToZGpr
import io.github.zap.build.gradle.convention.qs
import io.github.zap.build.gradle.convention.zgpr

// Uncomment to use local maven version - help local testing faster
plugins {
    // id("io.github.zap.build.gradle.convention.shadow-mc-plugin") version "0.0.0-SNAPSHOT"
    id("io.github.zap.build.gradle.convention.shadow-mc-plugin") version "1.1.0"
}

repositories {
    maven("https://repo.dmulloy2.net/repository/public/")
    maven(zgpr("zap-commons"))
    maven(zgpr("zap-party"))
    maven(zgpr("arena-api"))
}

dependencies {
    paperApi("1.16.5-R0.1-SNAPSHOT")
    compileOnlyApi("io.github.zap:zap-commons:1.1.0")

    bukkitPlugin("io.github.zap:arena-api:1.0.0-SNAPSHOT-1633307193", qs())
    bukkitPlugin("io.github.zap:zap-party:1.0.0-SNAPSHOT-1630956414", qs())
    bukkitPlugin("com.comphenix.protocol:ProtocolLib:4.7.0")
}

publishToZGpr()
