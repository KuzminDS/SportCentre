package com.ssu.Kuzmin.SportCentre.service;

import com.ssu.Kuzmin.SportCentre.dao.SubscriptionDao;
import com.ssu.Kuzmin.SportCentre.entity.Lesson;
import com.ssu.Kuzmin.SportCentre.entity.Subscription;

import java.util.List;

public class SubscriptionService extends Service<Subscription> {
    public SubscriptionService() {
        super(Subscription.class);
    }
}
