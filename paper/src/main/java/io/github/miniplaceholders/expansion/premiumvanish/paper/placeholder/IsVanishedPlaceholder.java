package io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.placeholder.AudiencePlaceholder;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class IsVanishedPlaceholder implements AudiencePlaceholder {
	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		String vanished = VanishAPI.isInvisible((Player) audience) ? "Yes" : "No";
		return Tag.preProcessParsed(vanished);
	}
}
