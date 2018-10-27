package com.two.lamps.psy.web.repository;

import com.two.lamps.psy.web.model.Client;
import com.two.lamps.psy.web.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position, Long> {

}
