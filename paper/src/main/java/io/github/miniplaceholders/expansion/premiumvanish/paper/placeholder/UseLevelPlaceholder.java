package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class UseLevelPlaceholder implements AudienceTagResolver<@NotNull Player> {
	@Override
	public @NotNull Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		int level = VanishAPI.getLayeredUsePermissionLevel(player);
		return Tag.preProcessParsed(String.valueOf(level));
	}
}
