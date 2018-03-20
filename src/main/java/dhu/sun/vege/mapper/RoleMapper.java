package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Role;
import dhu.sun.vege.util.core.BaseMapper;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2017/12/10
 */

public interface RoleMapper extends BaseMapper<Role> {
    Role selectRoleByUserId(Long id);
}
