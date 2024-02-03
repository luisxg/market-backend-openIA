package com.luis.service.impl;

import com.luis.model.Client;
import com.luis.repo.IClientRepo;
import com.luis.repo.IGenericRepo;
import com.luis.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends CRUDImpl<Client,Integer> implements IClientService {
    @Autowired
    private IClientRepo repo;

    @Override
    protected IGenericRepo<Client, Integer> getGenericRepo() {
        return repo;
    }

}
