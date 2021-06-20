package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.bots.Bot;

public class HermesReadyEvent extends HermesEvent {
    private final Bot triggerer;

    public HermesReadyEvent(final Hermes hermes, final Bot triggerer) {
        super(hermes);
        this.triggerer = triggerer;
    }

    public Bot getTriggerer() {
        return this.triggerer;
    }
}