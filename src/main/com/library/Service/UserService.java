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
     * @param loginName 登陸名
     * @param password  登錄密码
     * @return userDao
     */
    @Select("select * from tb_user where loginname=#{loginname} and password=#{password}")
    UserDao login(String loginName, String password);
}
