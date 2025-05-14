package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.placeholder.AudiencePlaceholder;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class VanishPrefixPlaceholder implements AudiencePlaceholder {
	private static final Tag TAG_PREFIX = Tag.selfClosingInserting(Component.text("[V] ", NamedTextColor.GREEN));
	private static final Tag TAG_EMPTY = Tag.preProcessParsed("");

	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		boolean invisible = VanishAPI.isInvisible((Player) audience);
		return invisible ? TAG_PREFIX : TAG_EMPTY;
	}
}
