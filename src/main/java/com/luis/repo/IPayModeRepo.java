package com.luis.repo;

import com.luis.model.PayMode;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayModeRepo extends IGenericRepo<PayMode, Integer> {
}
