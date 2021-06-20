package fr.blueberry.studio.hermes.api.plugins.events;

public class BotCreateEvent extends BotEvent {
    private String name;
    private final String token;

    public BotCreateEvent(final String name, final String token) {
        this.name = name;
        this.token = token;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.token;
    }

    public void setName(final String name) {
        this.name = name;
    }
}