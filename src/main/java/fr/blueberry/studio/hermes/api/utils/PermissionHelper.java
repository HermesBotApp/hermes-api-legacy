package fr.blueberry.studio.hermes.api.utils;

import fr.blueberry.studio.hermes.api.app.Hermes;
import net.dv8tion.jda.api.entities.User;

public class PermissionHelper {
    /**
     * Check if a user is an operator.
     * @param user - The user to check
     * @return - True if the user id is found in operators list.
     */
    public static boolean isOp(User user) {
        if(user != null) {
            return Hermes.getHermes().getHermesConfig().getOps().contains(user.getIdLong());
        }
        return false;
    }
}
