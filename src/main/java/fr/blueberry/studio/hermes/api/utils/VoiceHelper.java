package fr.blueberry.studio.hermes.api.utils;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.bots.Bot;
import fr.blueberry.studio.hermes.api.bots.BotManager;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.VoiceChannel;

public class VoiceHelper {

    /**
     * Get whether a member is in a voice channel
     * @param userId - The user id of the member
     * @param guild - The guild where to check the member voice state
     * @return - True if the member is connected in a voice channel
     */
    public static boolean isInVoice(long userId, Guild guild) {
        return getMemberVoiceChannel(String.valueOf(userId), guild) != null;
    }

    /**
     * Get whether a member is in a voice channel
     * @param userId - The user id of the member
     * @param guild - The guild where to check the member voice state
     * @return - True if the member is connected in a voice channel
     */
    public static boolean isInVoice(String userId, Guild guild) {
        return getMemberVoiceChannel(userId, guild) != null;
    }

    /**
     * Get the voice channel a member is currently in.
     * @param userId - The user id of the member
     * @param guild - The guild where to get voice channel from
     * @return - The voice channel or null
     */
    public static VoiceChannel getMemberVoiceChannel(String userId, Guild guild) {
        final Member member = guild.getMemberById(userId);

        if(member != null) {
            return member.getVoiceState().getChannel();
        }

        return null;
    }

    /**
     * Get the voice channel a member is currently in.
     * @param member - The member 
     * @return - The voice channel or null
     */
    public static VoiceChannel getMemberVoiceChannel(Member member) {
        if(member != null) {
            return member.getVoiceState().getChannel();
        }

        return null;
    }

    /**
     * Return whether a member is in a given voice channel or not
     * @param member - The member to get the channel
     * @param voiceChannel - The voice channel to check
     * @return - True if the member is in this specific channel
     */
    public static boolean isInChannel(Member member, VoiceChannel voiceChannel) {
        final VoiceChannel memberVoiceChannel = getMemberVoiceChannel(member);

        if(memberVoiceChannel != null) {
            return memberVoiceChannel.equals(voiceChannel);
        }

        return false;
    }

        /**
     * Return whether a member is in a given voice channel or not
     * @param user - The member to get the channel
     * @param voiceChannel - The voice channel to check
     * @return - True if the member is in this specific channel
     */
    public static boolean isInChannel(User user, VoiceChannel voiceChannel) {
        if(voiceChannel != null) {
            final Member member = voiceChannel.getGuild().getMember(user);

            if(member != null) {
                return isInChannel(member, voiceChannel);
            }
        }

        return false;
    }

    /**
     * Return whether a bot is in given voice channel or not.
     * @param voiceChannel - The voice channel to ask for the bot presence.
     * @return - True if there is a bot inside the voice channel.
     */
    public static boolean hasBotInChannel(VoiceChannel voiceChannel) {
        return getBotInChannel(voiceChannel) != null;
    }

    /**
     * Get the bot in the given voice channel
     * @param voiceChannel - The voice channel to ask for the bot.
     * @return - The bot or null if none is found.
     */
    public static Bot getBotInChannel(VoiceChannel voiceChannel) {
        final BotManager botManager = Hermes.getHermes().getBotManager();
        
        for(Bot bot : botManager.getAllConnectedBots()) {
            if(isInChannel(bot.getJDA().getSelfUser(), voiceChannel)) {
                return bot;
            }
        }
        return null;
    }
}
