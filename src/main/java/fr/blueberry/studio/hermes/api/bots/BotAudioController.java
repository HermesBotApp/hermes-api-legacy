package fr.blueberry.studio.hermes.api.bots;

import com.sedmelluq.discord.lavaplayer.player.AudioLoadResultHandler;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventAdapter;
import fr.blueberry.studio.hermes.api.audio.AudioPriority;

/**
 * 
 */
public interface BotAudioController {
    /**
     * Create an audio player with given name.
     * @param name - The name of the audio player.
     * @return - The Audio player freshly created.
     */
    AudioPlayer createAudioPlayer(String name);

    /**
     * Create an audio player with given name and custom audio event adapter.
     * @param name - The name of the audio player.
     * @param audioEventAdapter - The custom audio event adapter where to handle player events.
     * @return - The Audio player freshly created.
     */
    AudioPlayer createAudioPlayer(String name, AudioEventAdapter audioEventAdapter);

    /**
     * Create an audio player with given name, audip priority and custom audio event adapter.
     * @param name - The name of the audio player.
     * @param priority - The priority of the audio player used to define which player play on the top.
     * @param audioEventAdapter - The custom audio event adapter where to handle player events.
     * @return - The Audio player freshly created.
     */
    AudioPlayer createAudioPlayer(String name, AudioPriority priority, AudioEventAdapter audioEventAdapter);

    /**
     * Check if the bot has an audio player given by name.
     * @param name - The name of the audio player.
     * @return - True if an audio player with given name is found.
     */
    boolean hasAudioPlayer(String name);

    /**
     * Remove an audio player
     * @param name - The name of the audio player to remove.
     */
    void removeAudioPlayer(String name);

    /**
     * Get the audio player by name.
     * @param name - The name of the audio player.
     * @return - The audio player.
     */
    AudioPlayer getAudioPlayer(String name);

    /**
     * Load an audio into an audio player with custom AudioLoadResultHandler
     * @param identifier - The identifier of the audio (filename,url...)
     * @param audioPlayer - The audio player name which will play audio.
     * @param handler - The handler result of audio loading.
     */
    void loadAudio(String identifier, String audioPlayer, AudioLoadResultHandler handler);
    
    /**
     * Load an audio into an audio player with custom AudioLoadResultHandler
     * @param identifier - The identifier of the audio (filename,url...)
     * @param audioPlayer - The audio player which will play audio.
     * @param handler - The handler result of audio loading.
     */
    void loadAudio(String identifier, AudioPlayer audioPlayer, AudioLoadResultHandler handler);

    /**
     * Get if the bot is broadcasting audio.
     * @return - True if the bot is broadcasting audio.
     */
    boolean isBroadcasting();
}
