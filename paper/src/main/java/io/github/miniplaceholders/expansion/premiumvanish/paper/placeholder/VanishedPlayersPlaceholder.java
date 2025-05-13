package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.JoinConfiguration;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiFunction;

public final class VanishedPlayersPlaceholder implements BiFunction<ArgumentQueue, Context, Tag> {
	@Override
	public Tag apply(ArgumentQueue argumentQueue, Context context) {
		List<UUID> onlineVanishedPlayers = VanishAPI.getInvisiblePlayers();

		List<Component> playerComponents = new ArrayList<>();
		Bukkit.getOnlinePlayers().forEach(player -> {
			if (!onlineVanishedPlayers.contains(player.getUniqueId())) {
				return;
			}
			playerComponents.add(player.displayName().hoverEvent(Component.text(player.getUniqueId().toString())));
		});
		return Tag.selfClosingInserting(Component.join(JoinConfiguration.commas(true), playerComponents));
	}
}
