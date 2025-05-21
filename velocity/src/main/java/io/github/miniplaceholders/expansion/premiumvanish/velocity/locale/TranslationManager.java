package io.github.miniplaceholders.expansion.premiumvanish.velocity.locale;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.minimessage.translation.MiniMessageTranslationStore;
import net.kyori.adventure.translation.GlobalTranslator;
import net.kyori.adventure.translation.Translator;
import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.StringJoiner;

public final class TranslationManager {
	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;
	private final Logger logger;
	private final Path localeDirectoryPath;
	private MiniMessageTranslationStore store;

	public TranslationManager(Path path, Logger logger) {
		this.localeDirectoryPath = path.resolve("locale");
		this.logger = logger;
	}

	public void load() {
		if (this.store != null) {
			GlobalTranslator.translator().removeSource(this.store);
		}

		this.store = MiniMessageTranslationStore.create(Key.key("miniplaceholders", "premiumvanish"));
		this.store.defaultLocale(DEFAULT_LOCALE);

		createLocaleDirectory();
		copyDefaultBundleToLocaleDirectory();
		loadFromLocaleDirectory();

		GlobalTranslator.translator().addSource(this.store);
	}

	private void createLocaleDirectory() {
		try {
			Files.createDirectories(this.localeDirectoryPath);
		} catch (IOException e) {
			this.logger.error("Couldn't create locale directory", e);
		}
	}

	private void copyDefaultBundleToLocaleDirectory() {
		Path defaultBundlePath = this.localeDirectoryPath.resolve("messages_en.properties");
		if (Files.exists(defaultBundlePath)) {
			return;
		}

		try {
			Files.copy(this.getClass().getClassLoader().getResourceAsStream("messages_en.properties"), defaultBundlePath);
		} catch (IOException e) {
			this.logger.error("Could not write default bundle", e);
		}
	}

	private void loadFromLocaleDirectory() {
		StringJoiner loadedLocaleNamesJoiner = new StringJoiner(", ");

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(this.localeDirectoryPath, "*.properties")) {
			for (Path localeFilePath : stream) {
				String fileName = localeFilePath.getFileName().toString();
				if (!fileName.startsWith("messages_")) {
					this.logger.warn("Couldn't load {}. Locale files must follow specified naming convention", fileName);
					continue;
				}

				Locale locale = parseLocaleFromFileName(fileName);
				loadedLocaleNamesJoiner.add(locale.getLanguage());

				ResourceBundle bundle;
				try (BufferedReader reader = Files.newBufferedReader(localeFilePath, StandardCharsets.UTF_8)) {
					bundle = new PropertyResourceBundle(reader);
				}

				this.store.registerAll(locale, bundle, false);
			}

			if (loadedLocaleNamesJoiner.length() != 0) {
				this.logger.info("Loaded locales: {}", loadedLocaleNamesJoiner);
			}
		} catch (IOException e) {
			this.logger.warn("Couldn't read the locale directory", e);
		}
	}

	private Locale parseLocaleFromFileName(String fileName) {
		String localeString = fileName.substring(
				"messages_".length(),
				fileName.length() - ".properties".length()
		);
		Locale locale = Translator.parseLocale(localeString);
		if (locale == null) {
			throw new IllegalStateException("Couldn't parse locale for file name: " + fileName);
		}
		return locale;
	}
}
