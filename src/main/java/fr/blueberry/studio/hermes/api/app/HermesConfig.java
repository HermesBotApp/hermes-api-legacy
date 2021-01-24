package fr.blueberry.studio.hermes.api.app;

import java.util.List;

public interface HermesConfig {
    
    /**
     * Get the log level for this Hermes application.
     * @return - A String representating the log level (TRACE, DEBUG, INFO, WARN, ERROR, FATAL)
     */
    public String getLogLevel();

    /**
     * Get the list of operators.
     * @return - The list of discord user ids which are operators.
     */
    public List<Long> getOps();

    /**
     * Get the custom user message when a user doesn't have a permission to
     * execute something on this Hermes Application.
     * @return - The error message in String.
     */
    public String getNoPermissionMessage();

    /**
     * Get the custom user message when a user is executing a command
     * that doesn not exist yet on this Hermes Application.
     * @return - The no command message in String.
     */
    public String getNoCommandMessage();

    /**
     * Get the custom user message when a user is badly executing a command
     * with wrong arguments on this Hermes Application.
     * @return - The wrong command message in String.
     */
    public String getWrongMessage();
}
