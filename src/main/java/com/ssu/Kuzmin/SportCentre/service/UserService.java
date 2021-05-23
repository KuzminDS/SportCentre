package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.ClientDao;
import com.ssu.Kuzmin.SportCentre.dao.TrainerDao;
import com.ssu.Kuzmin.SportCentre.entity.Client;
import com.ssu.Kuzmin.SportCentre.entity.Trainer;
import com.ssu.Kuzmin.SportCentre.entity.User;

import java.util.List;

public class UserService {

    private final TrainerDao trainerDao;
    private final ClientDao clientDao;

    public UserService() {
        trainerDao = new TrainerDao();
        clientDao = new ClientDao();
    }

    public boolean authorize(String login, String password) throws Exception {
        List<Trainer> trainers = trainerDao.getAll();
        List<Client> clients = clientDao.getAll();

        boolean trainersResult = trainers.stream().anyMatch(t -> checkAuthorization(t, login, password));
        boolean clientsResult = clients.stream().anyMatch(t -> checkAuthorization(t, login, password));

        return trainersResult || clientsResult;
    }

    private boolean checkAuthorization(User user, String login, String password) {
        return user.getLogin() == login && user.getPassword() == password;
    }

}
