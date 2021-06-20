package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.bots.Bot;

public class BotTriggererDefinedEvent extends BotEvent {
    public BotTriggererDefinedEvent(final Bot bot) {
        super(bot);
    }
}
