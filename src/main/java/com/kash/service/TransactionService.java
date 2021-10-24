package com.kash.service;

import com.kash.entity.PrimaryAccount;
import com.kash.entity.PrimaryTransaction;
import com.kash.entity.SavingsTransaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionService extends CrudRepository<PrimaryTransaction, Long> {
    List<PrimaryTransaction> findPrimaryTransactionList();
    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);
    void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);
    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);
    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);
    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount) throws Exception;
}
