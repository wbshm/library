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

    boolean register(String name, String account, String password, String age);
}
