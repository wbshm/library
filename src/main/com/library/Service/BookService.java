package main.com.library.Service;

import main.com.library.Bean.BookDao;

import java.util.List;

public interface BookService {
    List<BookDao> getAll();
}
