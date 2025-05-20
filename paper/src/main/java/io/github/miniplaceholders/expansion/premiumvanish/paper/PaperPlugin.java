package io.github.miniplaceholders.expansion.premiumvanish.paper;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder.*;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class PaperPlugin extends JavaPlugin {
	public static final LegacyComponentSerializer SERIALIZER_LEGACY = LegacyComponentSerializer.legacyAmpersand();

	@Override
	public void onEnable() {
		this.getSLF4JLogger().info("Starting PremiumVanish Expansion for Paper");

		Expansion.builder("premiumvanish")
				.filter(Player.class)
				.audiencePlaceholder("isvanished", new IsVanishedPlaceholder())
				.audiencePlaceholder("vanishprefix", new VanishPrefixPlaceholder())
				.audiencePlaceholder("vanishsuffix", new VanishSuffixPlaceholder())
				.globalPlaceholder("vanishedplayers", new VanishedPlayersPlaceholder())
				.audiencePlaceholder("playercount", new PlayerCountPlaceholder())
				.audiencePlaceholder("uselevel", new UseLevelPlaceholder())
				.audiencePlaceholder("seelevel", new UseLevelPlaceholder())
				.build()
				.register();
	}
}
