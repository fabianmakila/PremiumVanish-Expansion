@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "PremiumVanish-Expansion"

pluginManagement {
	repositories {
		gradlePluginPortal()
	}
}

dependencyResolutionManagement {
	repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
	repositories {
		maven("https://repo.papermc.io/repository/maven-public/")
		maven("https://jitpack.io")
	}
}

arrayOf("paper", "universal", "velocity").forEach {
	include("premiumvanish-expansion-$it")
	project(":premiumvanish-expansion-$it").projectDir = file(it)
}