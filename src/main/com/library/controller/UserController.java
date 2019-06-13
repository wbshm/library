package main.com.library.controller;

import main.com.library.bean.UserDao;
import main.com.library.service.UserService;
import main.com.library.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        System.out.println(historyUserDao);
        if (null != historyUserDao) {
            mv.setView(new RedirectView("redirect:/book/list"));
        }
        if (null == userDao.getAccount()) {
            mv.setView(new RedirectView("login"));
        } else {
            session.setAttribute("account", null);
            session.setAttribute("password", null);
            UserDao user = userService.login(userDao.getAccount(), userDao.getPassword());
            System.out.println(user.toString());
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            if (null != user) {
                session.setAttribute("account", userDao.getAccount());
                session.setAttribute("password", userDao.getPassword());
                mv.setView(new RedirectView("redirect:/book/list"));
            } else {
                mv.addObject("message", "账号或者密码错误。请重试");
                mv.setViewName(TPL_PRE + "login");
            }
        }
        return mv;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String register() {
        return TPL_PRE + "register";
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(UserDao userDao) {
        userService.register(userDao.getName(), userDao.getAccount(), userDao.getPassword(), userDao.getAge());
        return TPL_PRE + "register";
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
