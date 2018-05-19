package dhu.sun.vege.model.dto;

import dhu.sun.vege.entity.Role;
import dhu.sun.vege.entity.User;

/**
 * Description
 *
 * @author
 * @date 2018/2/1
 */

public class UserDto extends User {
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
