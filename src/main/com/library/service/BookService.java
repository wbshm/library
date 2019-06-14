package main.com.library.service;

import main.com.library.bean.BookDao;

import java.util.List;

/**
 * @author wangrq
 */
public interface BookService {
    /**
     * 获取所有的队形
     * @return List
     */
    List<BookDao> getAll();

    /**
     * 根据id获取对象
     * @param id int
     * @return BookDao
     */
    BookDao getBookById(int id);

    /**
     * 更新对象
     * @param book
     * @return 影响的条数
     */
    int updateById(BookDao book);

    /**
     * 删除记录
     * @param id
     * @return 影响的条数
     */
    int deleteById(int id);

    /**
     * 插入记录
     * @param book
     * @return 影响条数
     */
    int insertBook(BookDao book);
}
