package main.com.library.Controller;

import main.com.library.Bean.BookDao;
import main.com.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;


    @RequestMapping("/save")
    public String saveBook() {
        return "index";
    }

    @RequestMapping("/list")
    public String getBookList(Model model) {
        List<BookDao> books = bookService.getAll();
        model.addAttribute("books", books);
        return "bookList";
    }

    @RequestMapping(value = "/find", method = {RequestMethod.POST, RequestMethod.GET}, params = {"pid", "z"})
    public String getBook() {
        return "";
    }
}
