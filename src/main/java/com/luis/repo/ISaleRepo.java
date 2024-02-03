package com.luis.repo;

import com.luis.model.Sale;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepo extends IGenericRepo<Sale, Integer> {
}
