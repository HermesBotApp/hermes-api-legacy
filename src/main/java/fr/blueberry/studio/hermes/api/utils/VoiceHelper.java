package fr.blueberry.studio.hermes.api.utils;

import fr.blueberry.studio.hermes.api.app.Hermes;
import fr.blueberry.studio.hermes.api.bots.Bot;
import net.dv8tion.jda.api.entities.*;

import java.util.Objects;
import java.util.Optional;

public final class VoiceHelper {

    private VoiceHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Get whether a member is in a voice channel
     * @param userId - The user id of the member
     * @param guild - The guild where to check the member voice state
     * @return - True if the member is connected in a voice channel
     */
    public static boolean isInVoice(final long userId, final Guild guild) {
        return isInVoice(String.valueOf(userId), guild);
    }

    /**
     * Get whether a member is in a voice channel
     * @param userId - The user id of the member
     * @param guild - The guild where to check the member voice state
     * @return - True if the member is connected in a voice channel
     */
    public static boolean isInVoice(final String userId, final Guild guild) {
        return Objects.nonNull(getMemberVoiceChannel(userId, guild));
    }

    /**
     * Get the voice channel a member is currently in.
     * @param userId - The user id of the member
     * @param guild - The guild where to get voice channel from
     * @return - The voice channel or null
     */
    public static VoiceChannel getMemberVoiceChannel(final String userId, final Guild guild) {
        return Optional.ofNullable(guild.getMemberById(userId))
                .map(VoiceHelper::getMemberVoiceChannel)
                .orElse(null);
    }

    /**
     * Get the voice channel a member is currently in.
     * @param member - The member 
     * @return - The voice channel or null
     */
    public static VoiceChannel getMemberVoiceChannel(final Member member) {
        return Optional.ofNullable(member)
                .map(Member::getVoiceState)
                .map(GuildVoiceState::getChannel)
                .orElse(null);
    }

    /**
     * Return whether a member is in a given voice channel or not
     * @param member - The member to get the channel
     * @param voiceChannel - The voice channel to check
     * @return - True if the member is in this specific channel
     */
    public static boolean isInChannel(final Member member, final VoiceChannel voiceChannel) {
        return Optional.ofNullable(getMemberVoiceChannel(member))
                .filter(voiceChannel::equals)
                .isPresent();
    }

    /**
     * Return whether a member is in a given voice channel or not
     * @param user - The member to get the channel
     * @param voiceChannel - The voice channel to check
     * @return - True if the member is in this specific channel
     */
    public static boolean isInChannel(final User user, final VoiceChannel voiceChannel) {
        return Optional.ofNullable(voiceChannel)
                .flatMap(channel -> Optional.ofNullable(channel.getGuild().getMember(user))
                        .map(member -> isInChannel(member, channel)))
                .orElse(false);
    }

    /**
     * Return whether a bot is in given voice channel or not.
     * @param voiceChannel - The voice channel to ask for the bot presence.
     * @return - True if there is a bot inside the voice channel.
     */
    public static boolean hasBotInChannel(final VoiceChannel voiceChannel) {
        return Objects.nonNull(getBotInChannel(voiceChannel));
    }

    /**
     * Get the bot in the given voice channel
     * @param voiceChannel - The voice channel to ask for the bot.
     * @return - The bot or null if none is found.
     */
    public static Bot getBotInChannel(final VoiceChannel voiceChannel) {
        return Hermes.getHermes().getBotManager().getAllConnectedBots().stream()
                .filter(bot -> isInChannel(bot.getJDA().getSelfUser(), voiceChannel))
                .findFirst()
                .orElse(null);
    }
}
