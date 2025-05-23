package com.example.usermanager.service;

import com.example.usermanager.model.User;

import java.util.List;

public interface IUserDAO {
    void insertUser(User user);

    User selectUser(int id);

    List<User> selectAllUser();

    boolean deleteUser(int id);

    boolean updateUser(User user);

    List<User> SortByName();

    User getUserById(int id);

    void insertUserStore(User user);

    void addUserTransaction(User user, List<Integer> permition);

    void insertUpdateWithoutTransaction();

}
