package fr.blueberry.studio.hermes.api.plugins;

import java.io.File;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Logger;
import fr.blueberry.studio.hermes.api.commands.CommandRegistry;

public interface PluginBase {
    
    File getDataFolder();

    Logger getLogger();

    Hermes getHermes();

    PluginMeta getPluginMeta();

    CommandRegistry getCommandRegistry();

    boolean isEnabled();
}