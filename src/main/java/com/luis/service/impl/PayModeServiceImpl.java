package com.luis.service.impl;

import com.luis.model.PayMode;
import com.luis.repo.IPayModeRepo;
import com.luis.repo.IGenericRepo;
import com.luis.service.IPayModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayModeServiceImpl extends CRUDImpl<PayMode,Integer> implements IPayModeService {
    @Autowired
    private IPayModeRepo repo;

    @Override
    protected IGenericRepo<PayMode, Integer> getGenericRepo() {
        return repo;
    }

}
