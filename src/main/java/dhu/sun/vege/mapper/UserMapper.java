package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.User;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2017/12/7
 */

public interface UserMapper extends BaseMapper<User> {
    User selectUserByUsername(String username);
    void updateUserByRoleId(Long roleId);
    List<User> getAllUserByRoleId(Long roleId);
}
