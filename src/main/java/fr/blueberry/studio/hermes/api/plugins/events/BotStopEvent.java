package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.bots.Bot;

public class BotStopEvent extends BotEvent {

    public BotStopEvent(final Bot bot) {
        super(bot);
    }
}