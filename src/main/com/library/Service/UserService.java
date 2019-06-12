package main.com.library.service;

import main.com.library.bean.UserDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wangrq
 */
public interface UserService {
    /**
     * 用户登陆
     *
     * @param name 登陸名
     * @param password  登錄密码
     * @return userDao
     */
    UserDao login(String name, String password);
}
