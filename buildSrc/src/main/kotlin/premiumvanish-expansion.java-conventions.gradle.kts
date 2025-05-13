plugins {
	java
}

group = rootProject.group
description = rootProject.description
version = rootProject.version

java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))

tasks {
	compileJava {
		options.encoding = Charsets.UTF_8.name()
	}
}