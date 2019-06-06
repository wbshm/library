package main.com.library.Controller;

import main.com.library.Bean.UserDao;
import main.com.library.Service.Impl.UserServiceImpl;
import main.com.library.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService = new UserServiceImpl();

    @RequestMapping("/login")
    public ModelAndView login(String name, String password, ModelAndView mv) {
        UserDao user = userService.login(name, password);
        if (user != null) {
            mv.setView(new RedirectView("/index"));
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
