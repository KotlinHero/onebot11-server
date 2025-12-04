plugins {
    kotlin("jvm")
    alias(libs.plugins.kotlin.serialization)
}

group = "tech.kotlinhero.onebot11.client.ktor"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(projects.onebot11ClientApi)

    implementation(projects.onebot11Post)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.websockets)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}