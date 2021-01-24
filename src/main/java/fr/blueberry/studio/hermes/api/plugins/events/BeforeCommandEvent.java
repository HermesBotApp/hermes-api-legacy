package fr.blueberry.studio.hermes.api.plugins.events;

import fr.blueberry.studio.hermes.api.app.Sender;
import fr.blueberry.studio.hermes.api.commands.ICommand;

public class BeforeCommandEvent extends Event {
    private ICommand command;
    private Sender sender;
    private String input;
    private String[] args;

    public BeforeCommandEvent(ICommand command, Sender sender, String input, String[] args) {
        this.command = command;
        this.sender = sender;
        this.input = input;
        this.args = args;
    }

    public ICommand getCommand() {
        return command;
    }

    public String getInput() {
        return input;
    }

    public Sender getSender() {
        return sender;
    }

    public String[] getArgs() {
        return args;
    }
}