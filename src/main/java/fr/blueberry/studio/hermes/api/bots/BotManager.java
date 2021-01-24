package fr.blueberry.studio.hermes.api.bots;

import java.io.IOException;
import java.util.ArrayList;

public interface BotManager {
    /**
     * Create an hermes bot
     * @param name - The hermes name of the bot (acts like an identifier)
     * @param token - The Discord token of the bot
     * @see Visit https://discord.com/developers/applications to get a token
     * @throws IOException - If something is wrong while reading / writing files.
     */
    void createBot(String name, String token) throws IOException;

    /**
     * Delete a bot
     * @param name - The name of the bot to delete. (Hermes identifier)
     */
    void deleteBot(String name);

    /**
     * Check if a bot exists with given name (Hermes identifier)
     * @param name - The name of the bot
     * @return - True if the bot exists
     */
    boolean nameExist(String name);

    /**
     * Check if a bot exists with given token (Discord token)
     * @param token - The token of the bot
     * @return - True if the bot exists
     */
    boolean tokenExist(String token);

    /**
     * Check if a bot exists with given name (Hermes identifier) and
     * given token.
     * @param name - The name of the bot
     * @param token - The token of the bot
     * @return - True if the bot exists
     */
    boolean exist(String name, String token);

    /**
     * Pick a random bot in the list of Hermes bots.
     * @param connectedConstraint - Should it pick connected to JDA only ?
     * @return - The random picked bot.
     */
    Bot pickRandomBot(boolean connectedConstraint);

    /**
     * Pick a random bot in the list of voice available Hermes bots.
     * @return - The random picked bot.
     */
    Bot pickRandomVoiceAvalaibleBot();

    /**
     * Get a bot by name
     * @param name - The name of the bot (Hermes identifier)
     * @return - The bot or null
     */
    Bot getBot(String name);

    /**
     * Get a bot by its discord user id
     * @param id - The discord user id of the bot
     * @return - The bot or null
     */
    Bot getBot(long id);

    /**
     * Get all the bots of the bot manager regardless
     * of the states.
     * @return - A list of all known bots on this hermes application.
     */
    ArrayList<Bot> getAllBots();

    /**
     * Get all connected bots (JDA connected) of the bot manager.
     * @return - A list containing all connected bots on this hermes application
     */
    ArrayList<Bot> getAllConnectedBots();

    /**
     * Get the triggerer of this hermes application.
     * @see Bot.getTriggerer()
     * @return - The bot triggerer of this hermes application.
     */
    Bot getTriggerer();

    /**
     * Get the bot count of this hermes application regardless of their states.
     * @return - The bot count of the application.
     */
    int getBotCount();

    /**
     * Get the connected bot count of this hermes application.
     * @return - The bot count of the application.
     */
    int getConnectedBotCount();

    /**
     * Get the JDA Listener manager of this Hermes application
     * @return - The JDA Listener manager.
     */
    JDAListenerManager getJDAListenerManager();

    /**
     * Shutdown all the connected bots.
     */
    void shutdownAll();
}