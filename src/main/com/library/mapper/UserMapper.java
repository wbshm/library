package main.com.library.mapper;

import main.com.library.bean.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 以#{}的方式表示sql中的参数 @param表示上面sql中的参数
     *
     * @param account 用户
     * @param password 密码
     * @return UserDao
     */
    @Select("select * from lib_user where account=#{account} and password=#{password} Limit 1")
    UserDao finwithLoginnameAndPassword(@Param("account") String account, @Param("password") String password);


    /**
     * 添加用户
     *
     * @param name     用户名
     * @param age      年龄
     * @param account  账户
     * @param password 密码
     * @return int
     */
    @Insert("INSERT INTO tb_user('name','password','age','account') VALUES (#{name},#{password},#{age},#{account})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int addUser(@Param("name") String name, @Param("account") String account, @Param("password") String password, @Param("age") int age);
}
