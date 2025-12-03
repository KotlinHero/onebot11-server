plugins {
    kotlin("jvm")
}

group = "tech.kotlinhero.onebot11.client.ktor"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}