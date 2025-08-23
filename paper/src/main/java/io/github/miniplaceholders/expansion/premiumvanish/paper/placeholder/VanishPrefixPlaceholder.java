package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import io.github.miniplaceholders.expansion.premiumvanish.paper.PaperPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class VanishPrefixPlaceholder implements AudienceTagResolver<@NotNull Player> {
	private static final Tag TAG_EMPTY = Tag.preProcessParsed("");

	@Override
	public @NotNull Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		boolean invisible = VanishAPI.isInvisible(player);
		if (!invisible) {
			return TAG_EMPTY;
		}
		Component prefix = PaperPlugin.message("Messages.PlaceholderVanishPrefix");
		if (prefix == null) {
			return TAG_EMPTY;
		}
		return Tag.selfClosingInserting(prefix);
	}
}
