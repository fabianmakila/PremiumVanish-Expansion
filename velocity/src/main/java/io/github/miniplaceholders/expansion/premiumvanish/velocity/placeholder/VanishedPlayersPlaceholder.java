package io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder;

import com.velocitypowered.api.proxy.ProxyServer;
import de.myzelyam.api.vanish.VelocityVanishAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

public final class VanishedPlayersPlaceholder implements BiFunction<ArgumentQueue, Context, Tag> {
	private final ProxyServer server;

	public VanishedPlayersPlaceholder(ProxyServer server) {
		this.server = server;
	}

	@Override
	public Tag apply(ArgumentQueue argumentQueue, Context context) {
		List<UUID> onlineVanishedPlayers = VelocityVanishAPI.getInvisiblePlayers();

		List<Component> playerComponents = new ArrayList<>();
		this.server.getAllPlayers().forEach(player -> {
			if (!onlineVanishedPlayers.contains(player.getUniqueId())) {
				return;
			}
			playerComponents.add(Component.text()
					.content(player.getUsername())
					.hoverEvent(Component.text(player.getUniqueId().toString()))
					.build()
			);
		});
		return Tag.selfClosingInserting(Component.join(JoinConfiguration.commas(true), playerComponents));
	}
}
