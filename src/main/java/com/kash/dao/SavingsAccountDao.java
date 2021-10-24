package com.kash.dao;

import com.kash.entity.PrimaryAccount;
import com.kash.entity.SavingsAccount;
import org.springframework.data.repository.CrudRepository;

public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {
    SavingsAccount findByAccountNumber(int accountNumber);
}
