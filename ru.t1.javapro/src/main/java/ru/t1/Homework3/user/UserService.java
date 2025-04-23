package ru.t1.Homework3.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserDao userDao;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void insertUser(String name) {
        userDao.insertUser(name);
    }

    public void deleteUser(String name) {
        userDao.deleteUser(name);
    }

    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void createTable() {
        userDao.createUserTable();
    }

    public void deleteTable() {
        userDao.deleteUserTable();
    }
}
