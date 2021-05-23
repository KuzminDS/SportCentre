package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.SubscriptionDao;
import com.ssu.Kuzmin.SportCentre.entity.Lesson;
import com.ssu.Kuzmin.SportCentre.entity.Subscription;

import java.util.List;

public class SubscriptionService {

    private final SubscriptionDao subscriptionDao;

    public SubscriptionService(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    public Subscription getById(int id) throws Exception {
        return subscriptionDao.getById(id);
    }

    public List<Subscription> getAll() {
        return subscriptionDao.getAll();
    }

    public void add(Subscription subscription) {
        subscriptionDao.add(subscription);
    }

    public void update(Subscription subscription) {
        subscriptionDao.update(subscription);
    }

    public void delete(Subscription subscription) {
        subscriptionDao.delete(subscription);
    }
}
