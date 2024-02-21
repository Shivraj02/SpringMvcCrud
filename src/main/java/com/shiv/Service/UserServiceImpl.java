package com.shiv.Service;

import java.util.List;

import com.shiv.Model.User;
import com.shiv.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public List listAllUser() {
        return userDao.listAllUser();
    }

    public String addUser(User user) {
        userDao.addUser(user);
        return "Successfully Added";
    }

    public String updateUser(User user) {
        userDao.updateUser(user);
        return "success";
    }

    public String delete(User user) {
        userDao.delete(user);
        return "Successfully Deleted";
    }


    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

}