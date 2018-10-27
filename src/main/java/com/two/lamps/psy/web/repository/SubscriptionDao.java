package com.two.lamps.psy.web.repository;

import com.two.lamps.psy.web.model.Client;
import com.two.lamps.psy.web.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionDao extends JpaRepository<Subscription, Long> {

}
