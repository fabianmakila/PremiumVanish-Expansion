plugins {
    java
    alias(libs.plugins.shadow)
}

group = "io.github.miniplaceholders"
description = "MiniPlaceholders PremiumVanish Expansion"
version = "1.0.0-SNAPSHOT"

dependencies {
    implementation(projects.premiumvanishExpansionVelocity)
    implementation(projects.premiumvanishExpansionPaper)
}

tasks {
    shadowJar {
        archiveFileName.set("MiniPlaceholders-${rootProject.name}-${project.version}.jar")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    }
    build {
        dependsOn(shadowJar)
    }
}
