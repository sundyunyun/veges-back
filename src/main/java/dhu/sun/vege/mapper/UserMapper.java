package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.User;
import dhu.sun.vege.util.core.BaseMapper;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2017/12/7
 */

public interface UserMapper extends BaseMapper<User> {
    User selectUserByUsername(String username);
}
