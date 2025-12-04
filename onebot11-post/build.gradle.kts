plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlin.serialization)
}

group = "tech.kotlinhero.onebot11.post"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kotlinx.serialization.json)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}