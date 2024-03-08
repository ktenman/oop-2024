group = "ee.ut"
version = "0.0.1-SNAPSHOT"

val assertjCoreVersion = "3.25.3"
val junitJupiterVersion = "5.10.2"

plugins {
    java
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation("org.assertj:assertj-core:$assertjCoreVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
