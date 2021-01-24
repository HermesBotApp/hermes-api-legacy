package fr.blueberry.studio.hermes.api.utils;

import java.util.HashMap;
import java.util.Map;
import java.awt.Color;
import org.simpleyaml.configuration.file.YamlFile;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

public final class MessageEmbedHelper {
    private MessageEmbedHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static EmbedBuilder getBuilder() {
        return new EmbedBuilder();
    }

    /**
     * Craft a fast embed message with only description.
     * @param description - The description of the embed
     * @return - The MessageEmbed freshly created
     */
    public static MessageEmbed fastEmbed(String description) {
        return new EmbedBuilder().setDescription(description).build();
    }

    /**
     * Craft a fast embed message with only title and description.
     * @param title - The title of the embed.
     * @param description - The description of the embed
     * @return - The MessageEmbed freshly created
     */
    public static MessageEmbed fastEmbed(String title, String description) {
        return new EmbedBuilder().setTitle(title).setDescription(description).build();
    }

    /**
     * Craft an embed from a config file with a given key
     * @param configKey - The base config key
     * @param config - The config file
     * @param replacements - The replacement double array
     * @return - The message embed freshly crafted
     */
    public static MessageEmbed craftEmbedFromConfig(String configKey, YamlFile config, String[][] replacements) {
        final Map<String, String> replacementsMapping = buildReplacementMap(replacements);
        
        return craftEmbedFromConfig(configKey, config, replacementsMapping);
    }

    /**
     * Craft an embed from a config file with a given key
     * @param configKey - The base config key
     * @param config - The config file
     * @param replacements - The replacement map
     * @return - The message embed freshly crafted
     */
    public static MessageEmbed craftEmbedFromConfig(String configKey, YamlFile config, Map<String, String> replacements) {
        final String title = replaceVars(config.getString(configKey + ".title"), replacements);
        final String description = replaceVars(config.getString(configKey + ".description"), replacements);
        final String image = config.getString(configKey + ".image");
        final String thumbnail = config.getString(configKey + ".thumbnail");
        final int r = config.getInt(configKey + ".color.r");
        final int g = config.getInt(configKey + ".color.g");
        final int b = config.getInt(configKey + ".color.b");
        final Color color = new Color(r,g,b);

        final MessageEmbed embed = getBuilder()
            .setTitle(title)
            .setDescription(description)
            .setColor(color)
            .setImage(image)
            .setThumbnail(thumbnail)
            .build();

        return embed;
    }

    /**
     * Craft an embed from a config file with a given key
     * @param configKey - The base config key
     * @param config - The config file
     * @return - The message embed freshly crafted
     */
    public static MessageEmbed craftEmbedFromConfig(String configKey, YamlFile config) {
        return craftEmbedFromConfig(configKey, config, new HashMap<>());
    }

    /**
     * Build the replacement map from a couple of String array
     * @param array - The array of the replacement map
     * @return - The replacement map ready to go 
     */
    public static Map<String, String> buildReplacementMap(String[][] array) {
        final HashMap<String, String> replacements = new HashMap<>();

        for(int i = 0; i < array.length; i++) {
            replacements.put(array[i][0], array[i][1]);
        }

        return replacements;
    }

    /**
     * Replace dynamics var in a String (%var%)
     * @param var - The String to replace variables in
     * @param replacements -
     * @return
     */
    private static String replaceVars(String var, Map<String, String> replacements) {
        if(var != null) {
            for(String tag : replacements.keySet()) {
                var = var.replaceAll(tag, replacements.get(tag));
            }
        }

        return var;
    }
}