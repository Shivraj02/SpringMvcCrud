package com.shiv.Service;

import com.shiv.Model.User;

import java.util.List;


public interface UserService {

    public List listAllUser();

    public String addUser(User user);

    public String updateUser(User user);

    public String delete(User user);

    public User findUserById(int id);
}