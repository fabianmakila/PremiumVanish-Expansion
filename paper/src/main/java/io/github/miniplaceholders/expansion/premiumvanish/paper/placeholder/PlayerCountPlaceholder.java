package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class PlayerCountPlaceholder implements AudienceTagResolver<@NotNull Player> {
	@Override
	public @NotNull Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		int playerCount = 0;
		for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
			if (VanishAPI.canSee(player, onlinePlayer)) {
				playerCount++;
			}
		}
		return Tag.preProcessParsed(String.valueOf(playerCount));
	}
}
