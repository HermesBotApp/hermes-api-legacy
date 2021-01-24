package fr.blueberry.studio.hermes.api.app;

public interface Logger {

    /**
     * Trace log a message.
     * @param message - The message to log.
     */
    void trace(String message);
    
    /**
     * Trace log a message and a Throwable
     * @param message - The message to log.
     */
    void trace(String message, Throwable t);
    
    /**
     * Debug log a message.
     * @param message - The message to log
     */
    void debug(String message);

    /**
     * Debug log a message and a Throwable
     * @param message - The message to log.
     */
    void debug(String message, Throwable t);

    /**
     * Info log a message.
     * @param message - The message to log
     */
    void info(String message);

    /**
     * Info log a message and a Throwable
     * @param message - The message to log.
     */
    void info(String message, Throwable t);

    /**
     * Warn log a message.
     * @param message - The message to log
     */
    void warn(String message);

    /**
     * Warn log a message and a Throwable
     * @param message - The message to log.
     */
    void warn(String message, Throwable t);
    
    /**
     * Error log a message.
     * @param message - The message to log
     */
    void error(String message);
    
    /**
     * Error log a message and a Throwable
     * @param message - The message to log.
     */
    void error(String message, Throwable t);

    /**
     * Fatal log a message.
     * @param message - The message to log
     */
    void fatal(String message);

    /**
     * Fatal log a message and a Throwable
     * @param message - The message to log.
     */
    void fatal(String message, Throwable t);
}