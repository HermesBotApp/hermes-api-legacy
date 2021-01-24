package fr.blueberry.studio.hermes.api.plugins;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import fr.blueberry.studio.hermes.api.plugins.events.Event;

public interface PluginManager {
    public static final String PLUGINS_FOLDER = System.getProperty("user.dir") + "/plugins/";
    
    File getPluginFolder();

    void registerEventListener(Plugin plugin, Listener listener);

    void unRegisterEventListeners(Plugin plugin, Class<? extends Event> clazz);

    void unRegisterAllEventsListener(Plugin plugin);

    boolean isEventListenerActive(Class<? extends Event> clazz);

    boolean isPluginEnabled(String name);

    boolean hasPlugin(String name);

    boolean hasPlugin(String name, boolean ignoreCase);

    boolean hasPlugin(Plugin plugin);

    Plugin getPlugin(String name);

    Plugin getPlugin(String name, boolean ignoreCase);

    void callEvent(Event event);

    void unloadPlugin(Plugin plugin);

    HashSet<ExecutableListener> getListeners(Class<? extends Event> clazz);

    HashSet<ExecutableListener> getListeners(Event event);

    Set<Plugin> getPlugins();

    void reload();
}