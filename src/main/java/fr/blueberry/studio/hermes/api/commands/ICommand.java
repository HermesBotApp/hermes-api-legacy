package fr.blueberry.studio.hermes.api.commands;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Logger;
import fr.blueberry.studio.hermes.api.app.Sender;

/**
 * Interface for commands
 */
public interface ICommand {
    /**
     * Get the command label.
     * @return - The command label.
     */
    String getLabel();

    /**
     * Get the command aliases. Empty array by default
     * @return - The list of command aliases.
     */
    default String[] getAliases() {
        return new String[]{};
    }

    /**
     * Get the command description. Empty string by default
     * @return - The command description
     */
    default String getDescription() {
        return "";
    }

    /**
     * Get the command usage. Empty string by default
     * @return - The usage of the command.
     */
    default String getUsage() {
        return "";
    }

    /**
     * Get whether the command is restricted to operators
     * member only or not. All commands are op restricted by default for security purposes, you
     * might have to un-restrict your command yourself.
     * @return
     */
    default boolean isOpRestricted() {
        return true;
    }

    /**
     * Execute the command
     * @param sender - The sender of the command.
     * @param args - The args of the command without label or aliases.
     */
    void execute(Sender sender, String[] args);

    /**
     * Get Hermes application
     * @return - Hermes application
     */
    Hermes getHermes();

    /**
     * Get the Logger of the application.
     * @return - The logger of the application.
     */
    Logger getLogger();
}