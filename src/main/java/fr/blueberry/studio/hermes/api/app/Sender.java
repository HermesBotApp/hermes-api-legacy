package fr.blueberry.studio.hermes.api.app;

import fr.blueberry.studio.hermes.api.bots.Bot;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;

public interface Sender {
    
    /**
     * Return whether a sender is operator or not.
     * @return - True if the sender is operator.
     */
    boolean isOp();

    /**
     * Return whether a sender has the permission to execute something or not.
     * @param permissionNode - The permission node to check.
     * @return - True if the sender depends of the permission node groups.
     */
    boolean hasPermission(String permissionNode);
    
    /**
     * Get a String representation of the sender.
     * @return - The identifier in String
     */
    String getIdentifier();

    /**
     * Get the Discord User associated with the sender.
     * @return - The JDA user.
     */
    User getUser();

    /**
     * Get the message channel from where come the sender.
     * @return - The Discord message channel.
     */
    MessageChannel getMessageChannel();

    /**
     * Send back a message to the location (TextChannel / Console / etc..) where the sender come from.
     * @param message - The message in String
     */
    void reply(String message);

    /**
     * Send back a message to the location (TextChannel / Console / etc..) where the sender come from.
     * @param messageEmbed - The message embed to reply
     */
    void reply(MessageEmbed messageEmbed);

    /**
     * Send back a message to the location (TextChannel / Console / etc..) where the sender come from.
     * @param messageEmbed - The messages embeds to reply
     */
    void reply(MessageEmbed... messageEmbed);

    /**
     * Send back a message to the location (TextChannel / Console / etc..) where the sender come from.
     * @param message - The message to reply
     * @param bot - The bot to use to reply
     */
    void reply(String message, Bot bot);

    /**
     * Send back a message to the location (TextChannel / Console / etc..) where the sender come from.
     * @param messageEmbed - The message embed to reply
     * @param bot - The bot to use to reply
     */
    void reply(MessageEmbed messageEmbed, Bot bot);
}