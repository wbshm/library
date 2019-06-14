package main.com.library.service;

import main.com.library.bean.UserDao;

/**
 * @author wangrq
 */
public interface UserService {
    /**
     * 用户登陆
     *
     * @param account  登陸名
     * @param password 登錄密码
     * @return userDao
     */
    UserDao login(String account, String password);

    /**
     * 注册账号
     *
     * @param userDao 用户对象
     * @return int 返回影响的行数
     */
    int register(UserDao userDao);
}
