plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlin.serialization)
}

group = "tech.kotlinhero.onebot11.client.api"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(projects.onebot11Post)
    compileOnly(libs.kotlinx.serialization.json)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}