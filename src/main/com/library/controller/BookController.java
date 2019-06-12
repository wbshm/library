package main.com.library.controller;

import main.com.library.service.BookService;
import main.com.library.bean.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author wangrq
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private String title;

    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("bookService") BookService bookService) {
        this.title = "图书管理系统";
        this.bookService = bookService;
    }


    @RequestMapping("/save")
    public String saveBook(ModelMap modelMap) {
        modelMap.addAttribute("title", this.title);
        return "index";
    }

    @RequestMapping("/list")
    public String getBookList(Model model) {
        List<BookDao> books = bookService.getAll();
        System.out.println(books);
        System.out.println(this.title);
        model.addAttribute("title", this.title);
        model.addAttribute("books", books);
        return "bookList";
    }

    @RequestMapping(value = "/find", method = {RequestMethod.POST, RequestMethod.GET}, params = {"pid", "z"})
    public String getBook() {
        return "";
    }
}
