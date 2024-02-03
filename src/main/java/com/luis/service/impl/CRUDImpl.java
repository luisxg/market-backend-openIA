package com.luis.service.impl;

import com.luis.repo.IGenericRepo;
import com.luis.service.ICRUDService;

import java.util.List;

public abstract class CRUDImpl<T,ID> implements ICRUDService<T,ID> {

    protected abstract IGenericRepo<T,ID> getGenericRepo();

    @Override
    public T save(T t) {
        return getGenericRepo().save(t);
    }

    @Override
    public T update(T t) {
        return getGenericRepo().save(t);
    }

    @Override
    public T findById(ID id) {
        return getGenericRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return getGenericRepo().findAll();
    }

    @Override
    public void delete(ID id) {
        getGenericRepo().deleteById(id);
    }


}
