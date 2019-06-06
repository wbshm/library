package main.com.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RequestMapping("/book")
public class bookController {

    @RequestMapping("/save")
    public String saveBook() {
        return "";
    }

    @RequestMapping("/getList")
    public String getBookList() {
        return "";
    }

    @RequestMapping(value = "/find", method = {RequestMethod.POST, RequestMethod.GET}, params = {"pid", "z"})
    public String getBook() {
        return "";
    }
}
