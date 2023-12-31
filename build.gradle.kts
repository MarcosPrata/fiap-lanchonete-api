import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.3" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	id("org.jetbrains.kotlin.plugin.jpa") version "1.8.10" apply false
	kotlin("jvm") version "1.8.10"
	kotlin("plugin.spring") version "1.8.10"
}

allprojects {
	group = "com.soat220"
	version = "1.0"

	repositories {
		mavenCentral()
	}
}

dependencies {
	subprojects.forEach {
		api(it)
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}


task<Exec>("up") { commandLine("docker-compose", "up") }