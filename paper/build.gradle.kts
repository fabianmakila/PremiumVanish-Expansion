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
    main = "io.github.miniplaceholders.premiumvanish.paper.PaperPlugin"
    author = "FabianAdrian"
    apiVersion = "1.21"
    dependencies {
        server {
            register("miniplaceholders") {
                required = true
                load = PaperPluginYaml.Load.BEFORE
            }
            register("premiumvanish") {
                required = true
                load = PaperPluginYaml.Load.BEFORE
            }
        }
    }
}
