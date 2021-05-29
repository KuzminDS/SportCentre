package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.TrainerDao;
import com.ssu.Kuzmin.SportCentre.entity.Subscription;
import com.ssu.Kuzmin.SportCentre.entity.Trainer;

import java.util.List;

public class TrainerService extends Service<Trainer> {
    public TrainerService() {
        super(Trainer.class);
    }
}
