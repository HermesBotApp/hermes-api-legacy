package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.bots.Bot;

public class BotReadyEvent extends BotEvent {
    public BotReadyEvent(final Bot bot) {
        super(bot);
    }
}