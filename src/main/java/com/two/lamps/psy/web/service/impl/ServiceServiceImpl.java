package com.two.lamps.psy.web.service.impl;

import com.two.lamps.psy.web.model.Service;
import com.two.lamps.psy.web.repository.ServiceDao;
import com.two.lamps.psy.web.service.ifc.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private ServiceDao serviceDao;

    @Autowired
    public ServiceServiceImpl(ServiceDao serviceDao) {
        this.serviceDao =  serviceDao;
    }

    @Override
    public void save(Service service) {
        serviceDao.save(service);
    }

    @Override
    public void delete(Service service) {
        serviceDao.delete(service);
    }
}
