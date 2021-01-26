package fr.blueberry.studio.hermes.api.app;

import com.sedmelluq.discord.lavaplayer.player.AudioPlayerManager;

import fr.blueberry.studio.hermes.api.bots.BotManager;
import fr.blueberry.studio.hermes.api.commands.CommandRegistry;
import fr.blueberry.studio.hermes.api.data.sql.DatabaseManager;
import fr.blueberry.studio.hermes.api.permissions.PermissionManager;
import fr.blueberry.studio.hermes.api.plugins.PluginManager;

/**
 * Hermes Discord main
 */
public abstract class Hermes {
    private static Hermes INSTANCE;

    public Hermes() {
        INSTANCE = this;
    }

    /**
     * Get the command registry where all the command are registered for this
     * Hermes application.
     * @return - The command registry to register / unregister commands.
     */
    public abstract CommandRegistry getCommandRegistry();

    /**
     * Get the bot manager responsible of managing all this Hermes application bots.
     * @return - The bot manager where are the bots.
     */
    public abstract BotManager getBotManager();

    /**
     * Get the logger of this Hermes Application
     * @return - The logger of this application.
     */
    public abstract Logger getLogger();

    /**
     * Get the plugin manager where are all the plugins.
     * @return - The plugin manager to load / unload plugins.
     */
    public abstract PluginManager getPluginManager();

    /**
     * Stop this hermes application.
     */
    public abstract void shutdown();

    /**
     * Get the execution time in milliseconds (ms) of this application.
     * @return - The time since the app started in milliseconds.
     */
    public abstract long getUptime();

    /**
     * Get the Hermes Configuration Java interface.
     * @return - Retrieve some custom configuration from Hermes main configuration file.
     */
    public abstract HermesConfig getHermesConfig();

    /**
     * Get the permission manager for this Hermes application.
     * @return - The permission manager responsible for holding permissions.
     */
    public abstract PermissionManager getPermissionManager();

    /**
     * Get the sedmelluq Discord audio player manager.
     * @return - The Audio player manager which manage audio
     */
    public abstract AudioPlayerManager getAudioPlayerManager();

    public abstract DatabaseManager getDatabaseManager();

    /**
     * Get this Hermes application main core.
     * @return - This Hermes application.
     */
    public static final Hermes getHermes() {
        return Hermes.INSTANCE;
    }
}