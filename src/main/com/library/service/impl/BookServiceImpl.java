package main.com.library.service.impl;

import main.com.library.bean.BookDao;
import main.com.library.mapper.BookMapper;
import main.com.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;


/**
 * //表示数据库隔离级别为如果当前有就使用当前，如果没有就创建新的事务，
 * //隔离级别为：读已提交，也就是数据在写入的时候是无法被读的，只有提交后才能让其他事务读取，防止数据库发生脏读
 *
 * @author wangrq
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
@Service("bookService")
public class BookServiceImpl implements BookService, Serializable {

    /**
     * 用构造方法代替 @Autowired
     */
    private final BookMapper bookMapper;

    /**
     * 用构造方法注入
     */
    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    /**
     * //数据库的读取方式为：只读
     *
     * @return List
     */
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public List<BookDao> getAll() {
        return bookMapper.getAll();
    }

    @Override
    public BookDao getBookById(int id) {
        return bookMapper.getBookById(id);
    }

    @Override
    public int updateById(BookDao book) {
//        return bookMapper.updateById(book.getAuthor(), book.getBook_name(), book.getCover(), book.getPrize(), book.getId());
        return bookMapper.updateById(book);
    }

    @Override
    public int deleteById(int id) {
        return bookMapper.deleteById(id);
    }

    @Override
    public int insertBook(BookDao book) {
        return bookMapper.insertBook(book);
    }
}
