package io.github.miniplaceholders.expansion.premiumvanish.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.proxy.ProxyReloadEvent;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.premiumvanish.velocity.locale.TranslationManager;
import io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder.*;
import org.slf4j.Logger;

import java.nio.file.Path;

public final class VelocityPlugin {
	private final Logger logger;
	private final ProxyServer server;
	private final TranslationManager translationManager;

	@Inject
	public VelocityPlugin(final ProxyServer server, final @DataDirectory Path dataDirectory, final Logger logger) {
		this.server = server;
		this.logger = logger;

		this.translationManager = new TranslationManager(dataDirectory, logger);
	}

	@Subscribe
	public void onProxyInitialize(final ProxyInitializeEvent event) {
		this.logger.info("Starting PremiumVanish Expansion for Velocity");

		this.translationManager.load();

		Expansion.builder("premiumvanish")
				.filter(Player.class)
				.audiencePlaceholder("isvanished", new IsVanishedPlaceholder())
				.audiencePlaceholder("vanishprefix", new VanishPrefixPlaceholder())
				.audiencePlaceholder("vanishsuffix", new VanishSuffixPlaceholder())
				.globalPlaceholder("vanishedplayers", new VanishedPlayersPlaceholder(this.server))
				.audiencePlaceholder("playercount", new PlayerCountPlaceholder(this.server))
				.audiencePlaceholder("uselevel", new UseLevelPlaceholder())
				.audiencePlaceholder("seelevel", new UseLevelPlaceholder())
				.build()
				.register();
	}

	@Subscribe
	public void onProxyReload(final ProxyReloadEvent event) {
		this.translationManager.load();
	}
}
