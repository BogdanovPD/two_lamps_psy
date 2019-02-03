package com.two.lamps.psy.web.service.impl;

import com.two.lamps.psy.web.model.Client;
import com.two.lamps.psy.web.repository.ClientDao;
import com.two.lamps.psy.web.service.ifc.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public void save(Client client) {
        clientDao.save(client);
    }

    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }
}
