package main.com.library.service;

import main.com.library.bean.BookDao;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookService {
    List<BookDao> getAll();
}
