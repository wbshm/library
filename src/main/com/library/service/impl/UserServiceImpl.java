package main.com.library.service.impl;

import main.com.library.bean.UserDao;
import main.com.library.mapper.UserMapper;
import main.com.library.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangrq
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
@Service("userService")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDao login(String account, String password) {
        return userMapper.finwithLoginnameAndPassword(account, password);
    }

    @Override
    public boolean register(String name, String account, String password, String age) {
        if (userMapper.finwithLoginnameAndPassword(account, password) == null) {
            int res = userMapper.addUser(name, age, account, password);
            System.out.println(res);
            return res > 0;
        }
        return false;
    }
}
