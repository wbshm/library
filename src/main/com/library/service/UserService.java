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
     * @param name     姓名
     * @param account  账号
     * @param password 密码
     * @param age      年龄
     * @return boolean
     */
    boolean register(String name, String account, String password, int age);
}
