package com.two.lamps.psy.web.repository;

import com.two.lamps.psy.web.model.Client;
import com.two.lamps.psy.web.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceDao extends JpaRepository<Service, Long> {

}
