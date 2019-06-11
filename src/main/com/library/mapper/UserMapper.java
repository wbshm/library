package main.com.library.mapper;

import main.com.library.bean.UserDao;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user where loginname=#{loginname} and password=#{password}") //以#{}的方式表示sql中的参数
    UserDao finwithLoginnameAndPassword(@Param("loginname")String loginname, @Param("password")String password);//@param表示上面sql中的参数

}
