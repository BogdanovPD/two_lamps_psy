package com.two.lamps.psy.web.service.impl;

import com.two.lamps.psy.web.model.Subscription;
import com.two.lamps.psy.web.repository.SubscriptionDao;
import com.two.lamps.psy.web.service.ifc.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private SubscriptionDao subscriptionDao;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionDao subscriptionDao) {
        this.subscriptionDao = subscriptionDao;
    }

    @Override
    public void save(Subscription subscription) {
        subscriptionDao.save(subscription);
    }

    @Override
    public void delete(Subscription subscription) {
        subscriptionDao.delete(subscription);
    }
}
