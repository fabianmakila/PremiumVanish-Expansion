plugins {
	id("premiumvanish-expansion.java-conventions")
	alias(libs.plugins.shadow)
}

dependencies {
	implementation(projects.premiumvanishExpansionVelocity)
	implementation(projects.premiumvanishExpansionPaper)
}

tasks {
	build {
		dependsOn(shadowJar)
	}
	shadowJar {
		archiveFileName.set("MiniPlaceholders-${rootProject.name}-${project.version}.jar")
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
		destinationDirectory.set(rootProject.layout.buildDirectory.dir("libs"))
	}
}