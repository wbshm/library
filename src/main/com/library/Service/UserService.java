package main.com.library.Service;

import main.com.library.Bean.UserDao;

public interface UserService {
    UserDao login(String Loginname, String password);
}
