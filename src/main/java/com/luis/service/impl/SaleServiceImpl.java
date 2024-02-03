package com.luis.service.impl;

import com.luis.model.Sale;
import com.luis.repo.ISaleRepo;
import com.luis.repo.IGenericRepo;
import com.luis.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceImpl extends CRUDImpl<Sale,Integer> implements ISaleService {
    @Autowired
    private ISaleRepo repo;

    @Override
    protected IGenericRepo<Sale, Integer> getGenericRepo() {
        return repo;
    }

}
