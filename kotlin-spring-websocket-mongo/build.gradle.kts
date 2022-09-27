import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val protobufVersion = "3.21.5"
val grpcVersion = "1.49.0"

plugins {
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"

    id("com.google.protobuf") version "0.8.19"
}

group = "com.toy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // mongoDB
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // WebSocket
    implementation("org.springframework.boot:spring-boot-starter-websocket")

    // Protobuf
    implementation("com.google.protobuf:protobuf-kotlin:$protobufVersion")
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")
    implementation("com.google.protobuf:protobuf-java-util:$protobufVersion")

    // GRPC
    implementation("io.grpc:grpc-okhttp:${grpcVersion}") // CURRENT_GRPC_VERSION
    implementation("io.grpc:grpc-stub:${grpcVersion}") // CURRENT_GRPC_VERSION
    implementation("io.grpc:grpc-protobuf:$grpcVersion")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
