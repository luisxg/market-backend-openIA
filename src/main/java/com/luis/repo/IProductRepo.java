package com.luis.repo;

import com.luis.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends IGenericRepo<Product, Integer> {
//    @Query("FROM Product p WHERE UNACCENT(LOWER(p.name)) = UNACCENT(:name)")
//    @Query("FROM Product p WHERE unaccent(p.name) ILIKE unaccent(:name) OR unaccent(p.name) ILIKE unaccent(:name || 's%')")
@Query("FROM Product p WHERE unaccent(p.name) ILIKE unaccent(:name) OR (unaccent(p.name) ILIKE unaccent(:name) || '%s')")
Product findByName(@Param("name") String name);

}
