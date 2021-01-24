package fr.blueberry.studio.hermes.api.permissions;

import fr.blueberry.studio.hermes.api.app.Sender;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;

public interface PermissionManager {

    /**
     * Refresh the permissions 
     */
    public void refreshPermissions();

    /**
     * Check if a sender has the given permission.
     * @param sender - The sender to check permissions
     * @param permission - The permission node
     * @return - True if the sender has the permission.
     */
    public boolean hasPermission(Sender sender, String permission);

    /**
     * Check if a member has the given permission.
     * @param member - The member to check permissions
     * @param permission - The permission node
     * @return - True if the member has the permission.
     */
    public boolean hasPermission(Member member, String permission);

    /**
     * Check if a role has the given permission.
     * @param role - The role to check permissions
     * @param permission - The permission node
     * @return - True if the role has the permission.
     */
    public boolean hasPermission(Role role, String permission);
    
    /**
     * Check if a role has the given permission.
     * @param roleId - The id of the role to check permissions
     * @param permission - The permission node
     * @return - True if the role has the permission.
     */
    public boolean hasPermission(long roleId, String permission);
}
