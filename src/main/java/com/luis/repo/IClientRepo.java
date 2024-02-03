package com.luis.repo;

import com.luis.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepo extends IGenericRepo<Client, Integer> {
}
