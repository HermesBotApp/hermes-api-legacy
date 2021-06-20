package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.app.Hermes;

public class HermesEvent extends Event {
    protected final Hermes hermes;

    public HermesEvent(final Hermes hermes) {
        this.hermes = hermes;
    }

    public Hermes getHermes() {
        return this.hermes;
    }
}
