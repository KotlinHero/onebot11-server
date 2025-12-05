plugins {
    kotlin("jvm")
}

group = "tech.kotlinhero.onebot11.client.api"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    api(projects.onebot11Post)

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}