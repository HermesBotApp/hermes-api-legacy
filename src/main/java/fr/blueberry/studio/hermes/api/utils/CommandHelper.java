package fr.blueberry.studio.hermes.api.utils;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.app.Sender;
import net.dv8tion.jda.api.entities.MessageEmbed;

public class CommandHelper {
    public static void sendCommandWrongArgs(Sender sender) {
        final String message = Hermes.getHermes().getHermesConfig().getWrongMessage();
        final MessageEmbed embed = MessageEmbedHelper.getBuilder().setDescription(message).build();
        
        sender.reply(embed);
    }

    public static void sendNoPermissions(Sender sender) {
        final String message = Hermes.getHermes().getHermesConfig().getNoPermissionMessage();
        final MessageEmbed embed = MessageEmbedHelper.getBuilder().setDescription(message).build();
        
        sender.reply(embed);
    }

    public static void sendNoCommand(Sender sender) {
        final String message = Hermes.getHermes().getHermesConfig().getNoCommandMessage();
        final MessageEmbed embed = MessageEmbedHelper.getBuilder().setDescription(message).build();
        
        sender.reply(embed);
    }
}