package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.TrainerDao;
import com.ssu.Kuzmin.SportCentre.entity.Subscription;
import com.ssu.Kuzmin.SportCentre.entity.Trainer;

import java.util.List;

public class TrainerService {

    private final TrainerDao trainerDao;

    public TrainerService(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }

    public Trainer getById(int id) throws Exception {
        return trainerDao.getById(id);
    }

    public List<Trainer> getAll() {
        return trainerDao.getAll();
    }

    public void add(Trainer trainer) {
        trainerDao.add(trainer);
    }

    public void update(Trainer trainer) {
        trainerDao.update(trainer);
    }

    public void delete(Trainer trainer) {
        trainerDao.delete(trainer);
    }
}
