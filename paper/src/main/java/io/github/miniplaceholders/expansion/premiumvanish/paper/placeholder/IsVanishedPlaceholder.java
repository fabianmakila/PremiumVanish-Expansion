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

public final class IsVanishedPlaceholder implements AudiencePlaceholder {
	private static final Tag TAG_EMPTY = Tag.preProcessParsed("");

	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		boolean vanished = VanishAPI.isInvisible((Player) audience);

		String key;
		if (vanished) {
			key = "Messages.PlaceholderIsVanishedYes";
		} else {
			key = "Messages.PlaceholderIsVanishedNo";
		}

		Component component = PaperPlugin.message(key);
		if (component == null) {
			return TAG_EMPTY;
		}

		return Tag.selfClosingInserting(component);
	}
}
