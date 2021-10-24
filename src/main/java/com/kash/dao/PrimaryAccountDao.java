package com.kash.dao;

import com.kash.entity.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount, Long> {
    PrimaryAccount findByAccountNumber(Integer accountNumber);
}
