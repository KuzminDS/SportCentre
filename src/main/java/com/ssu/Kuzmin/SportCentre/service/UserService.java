package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.ClientDao;
import com.ssu.Kuzmin.SportCentre.dao.TrainerDao;
import com.ssu.Kuzmin.SportCentre.dao.UserDao;
import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.entity.Trainer;
import com.ssu.Kuzmin.SportCentre.entity.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean registrate(User user) {
        return userDao.registrate(user);
    }

    public boolean authorize(User user) {
        return userDao.authorize(user);
    }
}
