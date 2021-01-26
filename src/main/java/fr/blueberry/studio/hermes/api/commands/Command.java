package fr.blueberry.studio.hermes.api.commands;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Logger;

/**
 * Command
 */
public abstract class Command implements ICommand {
    protected Hermes hermes;
    protected Logger logger;

    public Command() {
        this.hermes = Hermes.getHermes();
        this.logger = hermes.getLogger();
    }

    @Override
    public String[] getAliases() {
        return new String[]{};
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public String getUsage() {
        return "";
    }

    @Override
    public boolean isOpRestricted() {
        return true;
    }

    @Override
    public Hermes getHermes() {
        return hermes;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }
}
