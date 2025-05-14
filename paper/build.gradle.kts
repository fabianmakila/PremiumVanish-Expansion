import xyz.jpenilla.resourcefactory.paper.PaperPluginYaml

plugins {
    id("premiumvanish-expansion.java-conventions")
    alias(libs.plugins.resourcefactory.paper)
}

dependencies {
    compileOnly(libs.paper.api)
    compileOnly(libs.miniplaceholders)
    compileOnly(libs.premiumvanish)
}

paperPluginYaml {
    main = "io.github.miniplaceholders.expansion.premiumvanish.paper.PaperPlugin"
    author = "FabianAdrian"
    apiVersion = "1.21"
    dependencies {
        server {
            register("MiniPlaceholders") {
                required = true
                load = PaperPluginYaml.Load.BEFORE
            }
            register("PremiumVanish") {
                required = true
                load = PaperPluginYaml.Load.BEFORE
            }
        }
    }
}
