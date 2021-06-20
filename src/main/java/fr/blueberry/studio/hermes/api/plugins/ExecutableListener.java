package fr.blueberry.studio.hermes.api.plugins;

import fr.blueberry.studio.hermes.api.plugins.events.Event;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExecutableListener implements Comparable<ExecutableListener> {
    private final Plugin plugin;
    private final EventPriority eventPriority;
    private final Listener listener;
    private final boolean ignoreCancel;
    private final Method method;

    public ExecutableListener(final Plugin plugin, final EventPriority eventPriority, final Listener listener, final boolean ignoreCancel, final Method method) {
        this.plugin = plugin;
        this.eventPriority = eventPriority;
        this.listener = listener;
        this.ignoreCancel = ignoreCancel;
        this.method = method;
    }

    public void execute(final Event event) {
        try {
            method.invoke(listener, event);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int compareTo(final ExecutableListener o) {
        return Integer.compare(eventPriority.ordinal(), o.eventPriority.ordinal());
    }

    public Plugin getPlugin() {
        return this.plugin;
    }

    public boolean isCancelIgnored() {
        return this.ignoreCancel;
    }
}