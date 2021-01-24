package fr.blueberry.studio.hermes.api.bots;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * WARNING: All your Discord listeners have to be registered
 * from this interface to get tracked by Hermes. You may result in
 * event and command duplication if you register your listeners directly in JDA.
 */
public interface JDAListenerManager {
    /**
     * Register a JDA event to Hermes.
     * @param listenerAdapter - The listener of the event
     */
    void registerJDAListener(ListenerAdapter listenerAdapter);

    /**
     * Unregister a JDA event from Hermes.
     * @param listenerAdapter - The listener of the event
     */
    void unRegisterJDAListener(ListenerAdapter listenerAdapter);

    /**
     * Get the triggerer of this hermes application.
     * @see Bot.getTriggerer()
     * @return - The bot triggerer of this hermes application.
     */
    Bot getTriggerer();
}