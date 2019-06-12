package main.com.library.mapper;

import main.com.library.bean.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 以#{}的方式表示sql中的参数
     *
     * @param name
     * @param password
     * @return
     * @param表示上面sql中的参数
     */
    @Select("select * from lib_user where name=#{name} and password=#{password}")
    UserDao finwithLoginnameAndPassword(@Param("name") String name, @Param("password") String password);


    /**
     * @param name
     * @param password
     * @return
     */
    @Insert("INSERT INTO tb_user('name','password') VALUES (#{name},#{password})")
    boolean addUser(@Param("name") String name, @Param("password") String password);
}
