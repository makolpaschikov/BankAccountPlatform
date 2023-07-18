import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.1"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.22"
    kotlin("plugin.spring") version "1.8.22"
    kotlin("plugin.jpa") version "1.8.22"
}

group = "org.kolpaschikov"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    /* Starters */
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.1")
    implementation("org.springframework.boot:spring-boot-starter-log4j2:3.1.1")
    implementation("org.springframework.boot:spring-boot-starter-validation:3.1.1")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

    /* Database dependencies */
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.1.1")
    implementation("org.postgresql:postgresql:42.6.0")
//    implementation("org.flywaydb:flyway-core")

    /* Any */
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configurations {
    all {
        exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
