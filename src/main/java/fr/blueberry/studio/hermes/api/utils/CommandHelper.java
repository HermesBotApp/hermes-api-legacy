package fr.blueberry.studio.hermes.api.utils;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.HermesConfig;
import fr.blueberry.studio.hermes.api.app.Sender;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.function.Function;

public final class CommandHelper {
    private CommandHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    public static void sendCommandWrongArgs(final Sender sender) {
        sendMessage(sender, HermesConfig::getWrongMessage);
    }

    public static void sendNoPermissions(final Sender sender) {
        sendMessage(sender, HermesConfig::getNoPermissionMessage);
    }

    public static void sendNoCommand(final Sender sender) {
        sendMessage(sender, HermesConfig::getNoCommandMessage);
    }

    private static void sendMessage(final Sender sender, final Function<HermesConfig, String> messageSupplier) {
        final HermesConfig hermesConfig = Hermes.getHermes().getHermesConfig();
        final String message = messageSupplier.apply(hermesConfig);
        final MessageEmbed embed = MessageEmbedHelper.fastEmbed(message);

        sender.reply(embed);
    }
}