package io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder;

import com.velocitypowered.api.proxy.Player;
import de.myzelyam.api.vanish.VelocityVanishAPI;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class SeeLevelPlaceholder implements AudienceTagResolver<@NotNull Player> {
	@Override
	public @NotNull Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		int level = VelocityVanishAPI.getLayeredSeePermissionLevel(player);
		return Tag.preProcessParsed(String.valueOf(level));
	}
}
