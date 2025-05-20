plugins {
    id("premiumvanish-expansion.java-conventions")
    alias(libs.plugins.resourcefactory.velocity)
}

dependencies {
    compileOnly(libs.velocity.api)
    compileOnly(libs.miniplaceholders)
    compileOnly(libs.premiumvanish)
}

velocityPluginJson {
    main = "io.github.miniplaceholders.expansion.premiumvanish.velocity.VelocityPlugin"
    name = rootProject.name
    id = rootProject.name.lowercase()
    dependencies {
        dependency("miniplaceholders", optional = false)
        dependency("premiumvanish", optional = false)
    }
}