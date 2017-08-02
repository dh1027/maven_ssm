package com.ssm.service;

import com.ssm.dto.User;

import java.util.List;

public interface IUserService {

    public User getUserById(int userId);

    public void insertUser(User user);

    public void addUser(User user);

    public List<User> getAllUser();

    public User getUserByName(String name);
}