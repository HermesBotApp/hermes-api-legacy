package fr.blueberry.studio.hermes.api.plugins.events;

public abstract class Event {
    protected boolean canceled = false;

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}