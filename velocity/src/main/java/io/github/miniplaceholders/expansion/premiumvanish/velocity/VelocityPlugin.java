package io.github.miniplaceholders.expansion.premiumvanish.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.premiumvanish.velocity.locale.TranslationManager;
import io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder.*;
import org.slf4j.Logger;

public final class VelocityPlugin {
	private final Logger logger;
	private final ProxyServer server;

	@Inject
	public VelocityPlugin(final ProxyServer server, final Logger logger) {
		this.server = server;
		this.logger = logger;
	}

	@Subscribe
	public void onProxyInitialize(final ProxyInitializeEvent event) {
		this.logger.info("Starting PremiumVanish Expansion for Velocity");

		new TranslationManager(this.logger);

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
}
