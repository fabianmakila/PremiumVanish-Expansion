package io.github.miniplaceholders.expansion.premiumvanish.velocity.locale;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.minimessage.translation.MiniMessageTranslationStore;
import net.kyori.adventure.translation.GlobalTranslator;
import org.slf4j.Logger;

import java.util.Locale;
import java.util.ResourceBundle;

public final class TranslationManager {
	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
	private final Logger logger;
	private final MiniMessageTranslationStore store;

	public TranslationManager(Logger logger) {
		this.logger = logger;

		this.store = MiniMessageTranslationStore.create(Key.key("miniplaceholders", "premiumvanish"));
		this.store.defaultLocale(DEFAULT_LOCALE);

		loadFromResourceBundle();
		GlobalTranslator.translator().addSource(this.store);
	}

	private void loadFromResourceBundle() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("messages", DEFAULT_LOCALE);
			this.store.registerAll(DEFAULT_LOCALE, bundle, false);
		} catch (IllegalArgumentException e) {
			this.logger.warn("Error loading default locale file", e);
		}
	}
}
