package dhu.sun.vege.service.impl;

import dhu.sun.vege.service.SystemService;
import dhu.sun.vege.entity.User;
import dhu.sun.vege.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @author Tan Jie
 * @date 2018/2/1
 */

@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.selectAll();
    }
}
