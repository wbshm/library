package main.com.library.controller;

import main.com.library.bean.UserDao;
import main.com.library.service.UserService;
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

    @Autowired
    public UserController(@Qualifier("userService") UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(UserDao userDao, ModelAndView mv, HttpSession session) {
        UserDao historyUserDao = checkLogin(session);
        if (null != historyUserDao) {
            mv.setView(new RedirectView("index"));
        }
        if (null == userDao) {
            mv.setView(new RedirectView("login"));
        } else {
            session.setAttribute("username", null);
            session.setAttribute("password", null);
            UserDao user = userService.login(userDao.getName(), userDao.getPassword());
            System.out.println(userDao.getName());
            System.out.println(userDao.getPassword());
            if (null != user) {
                session.setAttribute("username", userDao.getName());
                session.setAttribute("password", userDao.getPassword());
                mv.setView(new RedirectView("index"));
            } else {
                mv.addObject("message", "账号或者密码错误。请重试");
                mv.setViewName("login");
            }
        }
        return mv;
    }


    public String register(String name, String password) {
        return "success";
    }

    private UserDao checkLogin(HttpSession session) {
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");
        String id       = session.getId();
        System.out.println(username);
        System.out.println(password);
        System.out.println(id);
        return userService.login(username, password);
    }


    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        return formName;
    }
}
