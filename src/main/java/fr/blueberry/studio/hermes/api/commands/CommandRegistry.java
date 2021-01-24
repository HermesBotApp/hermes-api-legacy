package fr.blueberry.studio.hermes.api.commands;

import java.util.Set;

import fr.blueberry.studio.hermes.api.plugins.Plugin;

public interface CommandRegistry {

    /**
     * Register a command to Hermes application.
     * @param command - The command to register.
     * @param plugin - The plugin which holds the command.
     */
    void registerCommand(Command command, Plugin plugin);

    /**
     * Unregister a command from Hermes application.
     * @param label - The label of the command to unregister.
     */
    void unRegisterCommand(String label);

    /**
     * Get whether a command is registered or not.
     * @param label - The label of the command.
     * @return - True if the command is found in Hermes.
     */
    boolean hasRegisteredCommand(String label);

    /**
     * Get the command by given label.
     * @param label - The label of the command to get.
     * @return - The command or null.
     */
    Command getCommand(String label);

    /**
     * Get a command by one of its alias
     * @param alias - The alias of the command to get.
     * @return - The command or null.
     */
    Command getCommandByAlias(String alias);

    /**
     * Get the command list.
     * @return - A string representation of the command list.
     */
    String getCommandList();

    /**
     * Get all the commands for a plugin.
     * @param plugin - The plugin to get the commands from.
     * @return - A list containing all the commands for a plugin.
     */
    Set<Command> getPluginCommands(Plugin plugin);

    /**
     * Get all the implemented by default hermes commands.
     * @return - A list containing all the hermes commands.
     */
    Set<Command> getHermesCommands();
}