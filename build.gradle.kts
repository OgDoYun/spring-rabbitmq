plugins {
	java
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
	id ("com.google.cloud.tools.jib") version "3.3.2"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-amqp")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.amqp:spring-rabbit-test")
}

jib {
	from {
		image = "openjdk:17"
	}
	to {
		image = "dyson/hello-jib"
		tags = setOf("latest")

	}
	container {
		jvmFlags = listOf("-Xms128m", "-Xmx128m")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
