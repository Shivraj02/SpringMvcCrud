package com.shiv.dao;

import com.shiv.Model.User;

import java.util.List;



public interface UserDao {

    public List listAllUser();

    public void addUser(User user);

    public void updateUser(User user);

    public void delete(User user);

    public User findUserById(int id);

}