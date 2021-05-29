package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.ClientDao;
import com.ssu.Kuzmin.SportCentre.entity.Client;

import java.util.List;


public class ClientService extends Service<Client> {

    public ClientService() {
        super(Client.class);
    }
}
