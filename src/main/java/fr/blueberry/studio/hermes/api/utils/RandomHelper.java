package fr.blueberry.studio.hermes.api.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomHelper {

    /**
     * Get a random value as integer and between bounds.
     * @param min - The min bound value
     * @param max - The max bound value
     * @return - A random number between bounds.
     */
    public static int getRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * Get a random index from a list
     * @param list - The list where to get random index
     * @return - The randomized index.
     */
    public static int getRandomIndex(List<?> list) {
        if(list.size() <= 0) {
            return 0;
        }
        return ThreadLocalRandom.current().nextInt(list.size());
    }
}