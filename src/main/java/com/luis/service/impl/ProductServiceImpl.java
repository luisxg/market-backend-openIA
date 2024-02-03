package com.luis.service.impl;

import com.luis.model.Product;
import com.luis.repo.IProductRepo;
import com.luis.repo.IGenericRepo;
import com.luis.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends CRUDImpl<Product,Integer> implements IProductService {
    @Autowired
    private IProductRepo repo;

    @Override
    protected IGenericRepo<Product, Integer> getGenericRepo() {
        return repo;
    }

    @Override
    public Product findByName(String name) {
        return repo.findByName(name);
    }
}
