package fr.blueberry.studio.hermes.api.plugins.events;

public class BotDeleteEvent extends BotEvent {
    private String name;

    public BotDeleteEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}