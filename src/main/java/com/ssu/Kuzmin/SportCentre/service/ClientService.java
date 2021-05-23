package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.ClientDao;
import com.ssu.Kuzmin.SportCentre.entity.Client;

import java.util.List;


public class ClientService {

    private final ClientDao clientDao;

    public ClientService() {
        this.clientDao = new ClientDao();
    }

    public Client getById(int id) throws Exception {
        return clientDao.getById(id);
    }

    public List<Client> getAll() {
        return clientDao.getAll();
    }

    public void add(Client client) {
        clientDao.add(client);
    }

    public void update(Client client) {
        clientDao.update(client);
    }

    public void delete(Client client) {
        clientDao.delete(client);
    }
}
