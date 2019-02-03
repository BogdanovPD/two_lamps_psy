package com.two.lamps.psy.web.service.impl;

import com.two.lamps.psy.web.model.Position;
import com.two.lamps.psy.web.repository.PositionDao;
import com.two.lamps.psy.web.service.ifc.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    private PositionDao positionDao;

    @Autowired
    public PositionServiceImpl(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @Override
    public void save(Position position) {
        positionDao.save(position);
    }

    @Override
    public void delete(Position position) {
        positionDao.delete(position);
    }
}
