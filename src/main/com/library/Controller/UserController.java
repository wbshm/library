package main.com.library.controller;

import main.com.library.bean.UserDao;
import main.com.library.service.impl.UserServiceImpl;
import main.com.library.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author wangrq
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Qualifier("userService")
    private UserService userService;


    @RequestMapping(value = "/login")
    public ModelAndView login(UserDao userDao, ModelAndView mv) {
        System.out.println(userDao.toString());
        if (userDao == null) {
            mv.setView(new RedirectView("index"));
        }
        UserDao user = userService.login(userDao.getName(), userDao.getPassword());
        if (user != null) {
            mv.setView(new RedirectView("index"));
        } else {
            mv.addObject("message", "错误");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping(value = "/{formName}")
    public String loginForm(@PathVariable String formName) {
        return formName;
    }
}
