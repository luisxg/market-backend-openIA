package com.luis.service.impl;

import com.luis.model.Category;
import com.luis.repo.ICategoryRepo;
import com.luis.repo.IGenericRepo;
import com.luis.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends CRUDImpl<Category,Integer> implements ICategoryService {
    @Autowired
    private ICategoryRepo repo;

    @Override
    protected IGenericRepo<Category, Integer> getGenericRepo() {
        return repo;
    }

}
