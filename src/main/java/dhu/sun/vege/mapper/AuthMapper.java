package dhu.sun.vege.mapper;

import dhu.sun.vege.entity.Auth;
import dhu.sun.vege.util.core.BaseMapper;

import java.util.List;

/**
 * Description
 *
 * @author
 * @date 2017/12/10
 */

public interface AuthMapper extends BaseMapper<Auth> {
    /**
     * 通过用户id查询用户的权限列表
     */
    List<Auth> selectAuthListByUserId(Long id);
}
