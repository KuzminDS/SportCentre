package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.GymDao;
import com.ssu.Kuzmin.SportCentre.entity.Group;
import com.ssu.Kuzmin.SportCentre.entity.Gym;

import java.util.List;

public class GymService extends Service<Gym> {
    public GymService() {
        super(Gym.class);
    }
}
