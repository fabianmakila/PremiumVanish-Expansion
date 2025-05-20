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

public final class IsVanishedPlaceholder implements AudiencePlaceholder {
	private static final Tag TAG_YES = Tag.selfClosingInserting(
			Component.translatable("miniplaceholders.expansion.premiumvanish.placeholder.isvanished.yes")
	);
	private static final Tag TAG_NO = Tag.selfClosingInserting(
			Component.translatable("miniplaceholders.expansion.premiumvanish.placeholder.isvanished.no")
	);

	@Override
	public @NotNull Tag tag(@NotNull Audience audience, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		boolean vanished = VelocityVanishAPI.isInvisible((Player) audience);
		return vanished ? TAG_YES : TAG_NO;
	}
}
