package fr.blueberry.studio.hermes.api.plugins;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Logger;
import fr.blueberry.studio.hermes.api.commands.CommandRegistry;
import org.simpleyaml.configuration.file.YamlFile;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public abstract class Plugin implements PluginBase {
    protected PluginMeta pluginMeta;
    protected Hermes hermes;
    protected YamlFile config;
    private boolean enabled;

    public Plugin() {
        this.pluginMeta = null;
        this.hermes= Hermes.getHermes();
        this.config = null;
        this.enabled = false;
    }
    
    public void onLoad() {}

    public void onEnable() {}

    public void onPostStart() {}

    public void onDisable() {}

    public void onNoTriggerer() {}

    @Override
    public File getDataFolder() {
        return new File(PluginManager.PLUGINS_FOLDER, pluginMeta.getName());
    }

    @Override
    public Logger getLogger() {
        return hermes.getLogger();
    }

    public Hermes getHermes() {
        return hermes;
    }

    public CommandRegistry getCommandRegistry() {
       return hermes.getCommandRegistry();
    }

    @Override
    public PluginMeta getPluginMeta() {
        return this.pluginMeta;
    }

    public YamlFile getConfiguration() {
        return Optional.ofNullable(this.config).orElseGet(YamlFile::new);
    }

    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void addPluginMeta(final PluginMeta pluginMeta) {
        this.pluginMeta = pluginMeta;
    }

    public void loadConfiguration(final YamlFile config) throws InvalidConfigurationException, IOException {
        this.config = config;
        this.config.load();
    }
}