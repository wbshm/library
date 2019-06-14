package main.com.library.controller;

import main.com.library.bean.BookDao;
import main.com.library.bean.JsonDao;
import main.com.library.bean.UserDao;
import main.com.library.service.BookService;
import main.com.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangrq
 */
@Controller
@RequestMapping("/book")
public class BookController {
    private String title;
    private final BookService bookService;
    private final UserService userService;
    private UserDao userDao;

    @Autowired
    public BookController(@Qualifier("bookService") BookService bookService, @Qualifier("userService") UserService userService) {
        this.title = "图书管理系统";
        this.bookService = bookService;
        this.userService = userService;
    }

    @RequestMapping("/save")
    public String saveBook(ModelMap modelMap) {
        modelMap.addAttribute("title", this.title);

        return "book/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, params = {"author", "book_name", "cover", "prize"})
    @ResponseBody
    public Object addBook(BookDao bookDao) {
        JsonDao jsonDao = new JsonDao();
        if (null == bookDao.getBook_name() || null == bookDao.getAuthor() || 0 == (int) bookDao.getPrize() || null == bookDao.getCover()) {
            jsonDao.setJson(-1, "参数错误");
        } else {
            int effectRow = bookService.insertBook(bookDao);
            if (effectRow > 0) {
                jsonDao.setJson(1, "添加成功", bookDao);
            } else {
                jsonDao.setJson(-3, "添加失败");
            }
        }
        return jsonDao;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView getBookList(ModelAndView mv, HttpServletRequest servletRequest) {
        if (!checkLogin(servletRequest.getSession())) {
            System.out.println("登陆失败哟");
            mv.setViewName("redirect:/user/login");
            return mv;
        }
        System.out.println("登陆成功");
        List<BookDao> books = bookService.getAll();
        mv.addObject("title", this.title);
        mv.addObject("books", books);
        mv.addObject("username", userDao.getName());
        mv.setViewName("/book/list");
        return mv;
    }

    @RequestMapping(value = "/find", method = {RequestMethod.POST, RequestMethod.GET}, params = {"pid", "z"})
    public String getBook() {
        return "";
    }

    private boolean checkLogin(HttpSession session) {
        String account = (String) session.getAttribute("account");
        String password = (String) session.getAttribute("password");
        userDao = userService.login(account, password);
        return userDao != null;
    }

    @RequestMapping(value = "/{formName}", method = RequestMethod.GET)
    public String loginForm(@PathVariable String formName) {
        System.out.println(formName);
        return "/book/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, params = "prize")
    @ResponseBody
    public Object update(@PathVariable int id, double prize) {
        BookDao book = bookService.getBookById(id);
        System.out.println(book.toString());
        JsonDao jsonDao = new JsonDao();
        if (book == null) {
            jsonDao.setJson(-3, "参数错误");
        } else {
            if (prize == book.getPrize()) {
                jsonDao.setJson(-3, "未做修改");
            } else {
                book.setPrize(prize);
                int res = bookService.updateById(book);
                if (res > 0) {
                    jsonDao.setJson(1, "更新成功", book);
                } else {
                    jsonDao.setJson(-3, "更新失败,看看你都传了什么鬼参数", book);
                }
            }
        }
        return jsonDao;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object delete(@PathVariable int id) {
        BookDao book = bookService.getBookById(id);
        JsonDao jsonDao = new JsonDao();
        if (book == null) {
            jsonDao.setCode(-3);
            jsonDao.setMsg("id错误");
        } else {
            int effectRow = bookService.deleteById(id);
            if (effectRow > 0) {
                jsonDao.setCode(1);
                jsonDao.setMsg("删除成功");
                HashMap map = new HashMap<String, Integer>();
                map.put("effectRow", effectRow);
                jsonDao.setData(map);
            }
        }
        return jsonDao;
    }
}
