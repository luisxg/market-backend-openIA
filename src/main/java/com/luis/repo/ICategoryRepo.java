package com.luis.repo;

import com.luis.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepo extends IGenericRepo<Category, Integer> {
}
