plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
}

group = "lv.stumburs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.formdev:flatlaf-intellij-themes:3.4.1")
    implementation("com.formdev:flatlaf:3.4.1")
}

tasks.test {
    useJUnitPlatform()
}

val mainClass = "lv.stumburs.Main"

tasks.jar {
    manifest {
        attributes["Main-Class"] = mainClass
    }
}