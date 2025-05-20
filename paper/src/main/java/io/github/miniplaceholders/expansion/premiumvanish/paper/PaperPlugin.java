package io.github.miniplaceholders.expansion.premiumvanish.paper;

import de.myzelyam.api.vanish.VanishAPI;
import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expansion.premiumvanish.paper.placeholder.*;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public final class PaperPlugin extends JavaPlugin {
	private static final LegacyComponentSerializer SERIALIZER_LEGACY = LegacyComponentSerializer.legacyAmpersand();
	private static final Pattern HEX_REPLACE_PATTERN = Pattern.compile("(?<!&)(#)([0-9a-fA-F]{6})");

	public static @Nullable Component message(String key) {
		String legacyString = VanishAPI.getMessages().getString(key);
		if (legacyString == null) {
			return null;
		}
		Matcher matcher = HEX_REPLACE_PATTERN.matcher(legacyString);
		legacyString = matcher.replaceAll("&#$2");

		return SERIALIZER_LEGACY.deserialize(legacyString);
	}

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
