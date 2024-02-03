package com.luis.service;

import com.luis.model.Product;

public interface IProductService extends ICRUDService<Product, Integer>{

    Product findByName(String name);
}
