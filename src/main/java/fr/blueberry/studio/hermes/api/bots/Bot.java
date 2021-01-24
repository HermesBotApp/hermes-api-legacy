package fr.blueberry.studio.hermes.api.bots;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;

public interface Bot {
    /**
     * Get the bot JDA Gateway API.
     * @return - The classical JDA API.
     */
    JDA getJDA();

    /**
     * Return whether a bot is connected (started) on Hermes or not.
     * /!\ WARNING : This does not determine if a bot is linked to Discord (i.e online), use 
     * @see isGatewayConnected instead.
     * @return - True if a bot is connected to Hermes.
     */
    boolean isConnected();

    /**
     * Is a bot the triggerer or not.
     * The triggerer is one of the bots which handle all incoming commands and events
     * in an Hermes application to avoid all sort of duplications. Only one triggerer is
     * defined at once. If a triggerer disconnect from Hermes, another one is defined if possible.
     * @return
     */
    boolean isTriggerer();

    /**
     * Get the name of the bot.
     * @return - The name of the bot (Hermes representation)
     */
    String getName();

    /**
     * Get the Discord user name
     * @return - The Discord user name of the bot.
     */
    String getDiscordName();

    /**
     * Get the type of the bot (Console, User, Broker)
     * @return - The String representation of the type.
     */
    String getType();

    /**
     * Get the status of the bot.
     * @return - The status of the bot.
     */
    String getStatusString();

    /**
     * Get the guild of the bot.
     * @return - The guild of the bot.
     */
    Guild getGuild();

    /**
     * Get the text channel given by id.
     * @param id - The id of the text channel.
     * @return - The TextChannel required.
     */
    TextChannel getTextChannel(long id);

    /**
     * Get whether the bot is connected to the Discord Gateway
     * @return - True if the bot is connected to Discord.
     */
    boolean isGatewayConnected();

    /**
     * Get the online status of this bot (ONLINE / DND / AWAY...)
     * @return - The online status of the bot
     */
    OnlineStatus getOnlineStatus();

    /**
     * Get whether the bot is available in voice chat.
     * @return - True if the bot is available for voice chat.
     */
    boolean isVoiceAvalaible();

    /**
     * Set the online status of the bot.
     * @param status - The online status to set.
     */
    void setOnlineStatus(OnlineStatus status);

    /**
     * Set the status of the bot.
     * @param status - The status to string
     */
    void setStatusString(String status);

    /**
     * Start a bot and connect to JDA Gateway.
     * @throws LoginException - If something is wrong while connecting.
     */
    void start() throws LoginException;

    /**
     * Stop a bot and disconnect from JDA.
     */
    void stop();

    /**
     * Save the bot in config
     * @throws IOException - If something is wrong while writing config.
     */
    void save() throws IOException;

    /**
     * Connect the bot to a voice channel.
     * @param voiceChannel - The target voice channel.
     */
    void connect(VoiceChannel voiceChannel);

    /**
     * Disconnect the bot from the voice channel he
     * is currently in. This is ignored if the bot is
     * already disconnected from voice chat.
     */
    void disconnect();

    /**
     * Send a message embed to the given channel.
     * @param messageChannel - The message channel where to send the message.
     * @param messageEmbed - The message embed to send.
     */
    void sendMessageTo(MessageChannel messageChannel, MessageEmbed messageEmbed);
    
    /**
     * Send a message embed to the given channel.
     * @param messageChannel - The message channel where to send the message.
     * @param message - The message to send.
     */
    void sendMessageTo(MessageChannel messageChannel, String message);

    /**
     * Send a message embed to the given user.
     * @param user - The user which will receive a message.
     * @param message - The message to send.
     */
    void sendMessageTo(User user, String message);

    /**
     * Send a message embed to the given user.
     * @param user - The user which will receive a message.
     * @param messageEmbed - The message embed to send.
     */
    void sendMessageTo(User user, MessageEmbed messageEmbed);

    /**
     * Add a reaction on a message
     * @param message - The message where to add the reaction.
     * @param emote - The emote to add
     */
    void addReaction(Message message, Emote emote);

    /**
     * Get the bot audio audio controller
     * @return - The bot audio controller.
     */
    BotAudioController getAudioController();
}