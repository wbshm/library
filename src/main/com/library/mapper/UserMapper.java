package main.com.library.mapper;

import main.com.library.bean.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author wangrq
 */
public interface UserMapper {

    /**
     * 以#{}的方式表示sql中的参数 @param表示上面sql中的参数
     *
     * @param account  用户
     * @param password 密码
     * @return UserDao
     */
    @Select("select * from lib_user where account=#{account} and password=#{password} Limit 1")
    UserDao finwithLoginnameAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 根据账户获取对象
     *
     * @param account
     * @return
     */
    @Select("select * from lib_user where account=#{account} limit 1")
    UserDao getUserByAccount(@Param("account") String account);


    /**
     * 更新
     *
     * @param userDao 用户对象
     * @return
     */
    @Update("UPDATE lib_user SET name=#{name},password=#{password},age=#{age},account=#{account} WHERE id=#{id}")
    int updateById(UserDao userDao);


    /**
     * 添加用户
     *
     * @param userDao 用户对象
     * @return int
     */
    @Insert("INSERT INTO lib_user(name,password,age,account) VALUES (#{name},#{password},#{age},#{account})")
    int addUser(UserDao userDao);
}
