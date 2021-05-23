package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.GymDao;
import com.ssu.Kuzmin.SportCentre.entity.Group;
import com.ssu.Kuzmin.SportCentre.entity.Gym;

import java.util.List;

public class GymService {

    private final GymDao gymDao;

    public GymService(GymDao gymDao) {
        this.gymDao = gymDao;
    }

    public Gym getById(int id) throws Exception {
        return gymDao.getById(id);
    }

    public List<Gym> getAll() {
        return gymDao.getAll();
    }

    public void add(Gym gym) {
        gymDao.add(gym);
    }

    public void update(Gym gym) {
        gymDao.update(gym);
    }

    public void delete(Gym gym) {
        gymDao.delete(gym);
    }
}
