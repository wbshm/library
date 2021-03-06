package main.com.library.mapper;

import main.com.library.bean.BookDao;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {
    String TABLE = "lib_book";

    /**
     * 返回book所有值
     *
     * @return List
     */
    @Select("Select * from " + TABLE + "")
    List<BookDao> getAll();

    /**
     * 根据id获取对象
     *
     * @param id
     * @return
     */
    @Select("Select * from " + TABLE + " where id=#{id} Limit 1")
    BookDao getBookById(@Param("id") int id);

    /**
     * 更新
     *
     * @param bookDao
     * @return
     */
    @Update("Update " + TABLE + " SET author=#{author},book_name=#{book_name},cover=#{cover},prize=#{prize} WHERE id=#{id}")
    int updateById(BookDao bookDao);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Delete("DELETE FROM " + TABLE + " WHERE id=#{id}")
    int deleteById(@Param("id") int id);

    /**
     * 插入
     *
     * @param bookDao
     * @return
     */
    @Insert("INSERT INTO " + TABLE + " (author,book_name,cover,prize) VALUES (#{author},#{book_name},#{cover},#{prize})")
    int insertBook(BookDao bookDao);
}