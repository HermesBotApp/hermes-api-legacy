package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.bots.Bot;

public class BotEvent extends Event {
    protected final Bot bot;

    public BotEvent() {
        this(null);
    }

    public BotEvent(final Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return this.bot;
    }
}