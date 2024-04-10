plugins {
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