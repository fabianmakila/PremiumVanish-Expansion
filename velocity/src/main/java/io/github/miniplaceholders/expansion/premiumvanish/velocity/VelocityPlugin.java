package io.github.miniplaceholders.expansion.premiumvanish.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.proxy.Player;
import io.github.miniplaceholders.api.Expansion;
import org.slf4j.Logger;

public final class VelocityPlugin {
	private final Logger logger;

	@Inject
	public VelocityPlugin(final Logger logger) {
		this.logger = logger;
	}

	@Subscribe
	public void onProxyInitialize(final ProxyInitializeEvent event) {
		logger.info("Starting PremiumVanish Expansion for Velocity");

		Expansion.builder("premiumvanish")
				.filter(Player.class)
				.build()
				.register();
	}
}
