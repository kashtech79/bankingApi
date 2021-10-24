package com.kash.dao;

import com.kash.entity.PrimaryTransaction;
import com.kash.entity.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {
    List<SavingsTransaction> findAll();
}
