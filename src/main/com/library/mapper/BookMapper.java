package main.com.library.mapper;

import main.com.library.bean.BookDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    /**
     * 返回book所有值
     * @return List
     */
    @Select("Select * from lib_book")
    List<BookDao> getAll();
}