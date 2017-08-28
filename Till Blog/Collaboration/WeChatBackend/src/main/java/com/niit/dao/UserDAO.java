package com.niit.dao;

import java.util.List;

import com.niit.model.User;

public interface UserDAO {
void registerUser(User user);
User validateUsername(String username);
User validateEmail(String email);
User login(User user);
void update(User user);
User getUserByUsername(String username);
}
