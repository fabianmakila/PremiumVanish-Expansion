# PremiumVanish-Expansion
PremiumVanish Expansion for MiniPlaceholders

## Paper

The expansion uses messages defined in the `plugins/PremiumVanish/messages.yml` file which can be changed from there.

<table>
    <tr>
        <th>Placeholder</th>
        <th>Type</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_isvanished&gt;</code></td>
        <td>Audience</td>
        <td>Returns either <code>Messages.PlaceholderIsVanishedYes</code> or <code>Messages.PlaceholderIsVanishedNo</code></td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_vanishprefix&gt;</code></td>
        <td>Audience</td>
        <td>When a player is vanished returns <code>Messages.PlaceholderVanishPrefix</code></td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_vanishsuffix&gt;</code></td>
        <td>Audience</td>
        <td>When a player is vanished returns <code>Messages.PlaceholderVanishSuffix</code></td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_vanishedplayers&gt;</code></td>
        <td>Global</td>
        <td>Returns a comma seperated list of online vanished players.</td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_playercount&gt;</code></td>
        <td>Audience</td>
        <td>Returns the amount of players a player can see.</td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_uselevel&gt;</code></td>
        <td>Audience</td>
        <td>Returns a player's use vanish permission level.</td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_seelevel&gt;</code></td>
        <td>Audience</td>
        <td>Returns a player's see vanish permission level.</td>
    </tr>
</table>

## Velocity

Messages can be changed by modifying the `messages_en.properties` file in `plugins/miniplaceholders-premiumvanish-expansion/locale` directory.
For per-player locales, you can add more `.properties` files for other locales to the directory.

<table>
    <tr>
        <th>Placeholder</th>
        <th>Type</th>
        <th>Description</th>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_isvanished&gt;</code></td>
        <td>Audience</td>
        <td>Returns either <code>miniplaceholders.expansion.premiumvanish.placeholder.isvanished.yes</code> or <code>miniplaceholders.expansion.premiumvanish.placeholder.isvanished.no</code></td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_vanishprefix&gt;</code></td>
        <td>Audience</td>
        <td>When a player is vanished returns <code>miniplaceholders.expansion.premiumvanish.placeholder.prefix</code></td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_vanishsuffix&gt;</code></td>
        <td>Audience</td>
        <td>When a player is vanished returns <code>miniplaceholders.expansion.premiumvanish.placeholder.suffix</code></td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_vanishedplayers&gt;</code></td>
        <td>Global</td>
        <td>Returns a comma seperated list of online vanished players.</td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_playercount&gt;</code></td>
        <td>Audience</td>
        <td>Returns the amount of players a player can see.</td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_uselevel&gt;</code></td>
        <td>Audience</td>
        <td>Returns a player's use vanish permission level.</td>
    </tr>
    <tr>
        <td><code>&lt;premiumvanish_seelevel&gt;</code></td>
        <td>Audience</td>
        <td>Returns a player's see vanish permission level.</td>
    </tr>
</table>