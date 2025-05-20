package io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder;

import com.velocitypowered.api.proxy.Player;
import de.myzelyam.api.vanish.VelocityVanishAPI;
import io.github.miniplaceholders.api.placeholder.AudiencePlaceholder;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class VanishPrefixPlaceholder implements AudiencePlaceholder {
	private static final Tag TAG_EMPTY = Tag.preProcessParsed("");
	private static final Tag TAG_PREFIX = Tag.inserting(
			Component.translatable("miniplaceholders.expansion.premiumvanish.placeholder.prefix")
	);

	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		boolean invisible = VelocityVanishAPI.isInvisible((Player) audience);
		return invisible ? TAG_PREFIX : TAG_EMPTY;
	}
}
