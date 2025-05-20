package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.placeholder.AudiencePlaceholder;
import io.github.miniplaceholders.expansion.premiumvanish.paper.PaperPlugin;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class VanishSuffixPlaceholder implements AudiencePlaceholder {
	private static final Tag TAG_EMPTY = Tag.preProcessParsed("");

	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		boolean invisible = VanishAPI.isInvisible((Player) audience);
		if (!invisible) {
			return TAG_EMPTY;
		}
		Component suffix = PaperPlugin.message("Messages.PlaceholderVanishSuffix");
		if (suffix == null) {
			return TAG_EMPTY;
		}
		return Tag.selfClosingInserting(suffix);
	}
}
