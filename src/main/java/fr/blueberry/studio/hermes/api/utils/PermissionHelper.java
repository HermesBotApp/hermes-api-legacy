package fr.blueberry.studio.hermes.api.utils;

import fr.blueberry.studio.hermes.api.app.Hermes;
import net.dv8tion.jda.api.entities.ISnowflake;
import net.dv8tion.jda.api.entities.User;

import java.util.Optional;

public final class PermissionHelper {

    private PermissionHelper() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * Check if a user is an operator.
     * @param user - The user to check
     * @return - True if the user id is found in operators list.
     */
    public static boolean isOp(final User user) {
        return Optional.ofNullable(user)
                .map(ISnowflake::getIdLong)
                .filter(Hermes.getHermes().getHermesConfig().getOps()::contains)
                .isPresent();
    }
}
