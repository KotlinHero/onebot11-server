plugins {
    kotlin("jvm")
    alias(libs.plugins.ktor)
    application
}

group = "tech.kotlinhero.oneday"
version = "1.0.0"

application {
    mainClass.set("tech.kotlinhero.onebot11.server.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    implementation(projects.onebot11ClientKtor)

    implementation(libs.logback)
    implementation(libs.ktor.serverCore)
    implementation(libs.ktor.serverNetty)
    testImplementation(libs.ktor.serverTestHost)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.websockets)

    testImplementation(kotlin("test"))
}