package fr.blueberry.studio.hermes.api.utils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomHelper {

    private RandomHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Get a random value as integer and between bounds.
     * @param min - The min bound value
     * @param max - The max bound value
     * @return - A random number between bounds.
     */
    public static int getRandom(final int min, final int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * Get a random index from a list
     * @param list - The list where to get random index
     * @return - The randomized index.
     */
    public static int getRandomIndex(final List<?> list) {
        return Optional.ofNullable(list)
                .filter(l -> !l.isEmpty())
                .map(List::size)
                .map(ThreadLocalRandom.current()::nextInt)
                .orElse(0);
    }
}