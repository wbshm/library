package main.com.library.Service.Impl;

import main.com.library.Bean.BookDao;
import main.com.library.Service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

//@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Override
    public List<BookDao> getAll() {
        return null;
    }
}
