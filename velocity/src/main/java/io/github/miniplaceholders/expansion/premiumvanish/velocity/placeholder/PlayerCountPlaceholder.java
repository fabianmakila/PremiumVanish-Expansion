package io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder;

import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import de.myzelyam.api.vanish.VelocityVanishAPI;
import io.github.miniplaceholders.api.placeholder.AudiencePlaceholder;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class PlayerCountPlaceholder implements AudiencePlaceholder {
	private final ProxyServer server;

	public PlayerCountPlaceholder(ProxyServer server) {
		this.server = server;
	}

	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		Player player = (Player) audience;
		int playerCount = 0;
		for (Player onlinePlayer : this.server.getAllPlayers()) {
			if (VelocityVanishAPI.canSee(player, onlinePlayer)) {
				playerCount++;
			}
		}
		return Tag.preProcessParsed(String.valueOf(playerCount));
	}
}
