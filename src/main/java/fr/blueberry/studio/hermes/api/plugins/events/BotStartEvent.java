package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.bots.Bot;

public class BotStartEvent extends BotEvent {

    public BotStartEvent(final Bot bot) {
        super(bot);
    }
}