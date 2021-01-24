package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.bots.Bot;

public class BotEvent extends Event {
    private final Bot bot;

    public BotEvent() {
        this.bot = null;
    }

    public BotEvent(Bot bot) {
        this.bot = bot;
    }

    public Bot getBot() {
        return this.bot;
    }
}