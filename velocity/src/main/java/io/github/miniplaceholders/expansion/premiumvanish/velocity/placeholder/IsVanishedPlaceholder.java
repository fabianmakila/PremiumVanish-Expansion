package io.github.miniplaceholders.expansion.premiumvanish.velocity.placeholder;

import com.velocitypowered.api.proxy.Player;
import de.myzelyam.api.vanish.VelocityVanishAPI;
import io.github.miniplaceholders.api.resolver.AudienceTagResolver;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class IsVanishedPlaceholder implements AudienceTagResolver<@NotNull Player> {
	private static final Tag TAG_YES = Tag.selfClosingInserting(
			Component.translatable("miniplaceholders.expansion.premiumvanish.placeholder.isvanished.yes")
	);
	private static final Tag TAG_NO = Tag.selfClosingInserting(
			Component.translatable("miniplaceholders.expansion.premiumvanish.placeholder.isvanished.no")
	);

	@Override
	public @NotNull Tag tag(@NotNull Player player, @NotNull ArgumentQueue queue, @NotNull Context ctx) {
		return VelocityVanishAPI.isInvisible(player) ? TAG_YES : TAG_NO;
	}
}
