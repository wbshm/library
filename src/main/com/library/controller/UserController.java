package main.com.library.controller;

import main.com.library.bean.JsonDao;
import main.com.library.bean.UserDao;
import main.com.library.service.UserService;
import main.com.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

/**
 * @author wangrq
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private static final String TPL_PRE = "user/";

    @Autowired
    public UserController(@Qualifier("userService") UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(UserDao userDao, ModelAndView mv, HttpSession session) {
        System.out.println("登陆执行了。" + userDao.getAccount() + userDao.getPassword());
        UserDao historyUserDao = checkLogin(session);
        System.out.println("打印" + userDao.toString());
        //如果有cookie记录的话，则跳转至
        if (null != historyUserDao) {
            mv.setViewName("redirect:/book/list");
        } else {
            if (null == userDao.getAccount()) {
                mv.setView(new RedirectView("user/login"));
            } else {
                session.setAttribute("account", null);
                session.setAttribute("password", null);
                UserDao user = userService.login(userDao.getAccount(), userDao.getPassword());
                if (null != user) {
                    session.setAttribute("account", userDao.getAccount());
                    session.setAttribute("password", userDao.getPassword());
                    mv.setViewName("redirect:/book/list");
                } else {
                    mv.addObject("message", "账号或者密码错误。请重试");
                    mv.setViewName(TPL_PRE + "login");
                }
            }
        }
        return mv;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.setAttribute("account", null);
        session.setAttribute("password", null);
        return TPL_PRE + "login";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return TPL_PRE + "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST, params = {"name", "account", "password", "age"})
    @ResponseBody
    public Object register(UserDao userDao) {
        JsonDao jsonDao = new JsonDao();
        int res = userService.register(userDao);
        if (res > 0) {
            System.out.println("成功插入:" + res);
            jsonDao.setJson(1, "注册成功");
        } else {
            jsonDao.setJson(-3, "注册失败");
        }
        return jsonDao;
    }

    private UserDao checkLogin(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String id = session.getId();
        System.out.println(username);
        System.out.println(password);
        System.out.println(id);
        return userService.login(username, password);
    }

    @RequestMapping(value = "/{formName}", method = RequestMethod.GET)
    public String loginForm(@PathVariable String formName) {
        return TPL_PRE + formName;
    }
}
