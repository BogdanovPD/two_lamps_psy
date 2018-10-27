package com.two.lamps.psy.web.repository;

import com.two.lamps.psy.web.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<Client, Long> {

}
