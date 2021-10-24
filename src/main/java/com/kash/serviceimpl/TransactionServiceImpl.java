package com.kash.serviceimpl;

import com.kash.dao.PrimaryAccountDao;
import com.kash.dao.PrimaryTransactionDao;
import com.kash.dao.SavingsAccountDao;
import com.kash.dao.SavingsTransactionDao;
import com.kash.entity.PrimaryAccount;
import com.kash.entity.PrimaryTransaction;
import com.kash.entity.SavingsTransaction;
import com.kash.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private PrimaryTransactionDao primaryTransactionDao;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsTransactionDao savingsTransactionDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;




    public List<PrimaryTransaction> findPrimaryTransactionList() {
        return null;
    }

    public void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }

    public void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction) {
        primaryTransactionDao.save(primaryTransaction);
    }


    public void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);

    }

    public void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction) {
        savingsTransactionDao.save(savingsTransaction);
    }

    @Override
    public void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount) throws Exception {

    }


//    public Optional<PrimaryTransaction> findById(Long aLong) {
//        return Optional.empty();
//    }

    @Override
    public <S extends PrimaryTransaction> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PrimaryTransaction> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PrimaryTransaction> findById(Long aLong) {
        return Optional.empty();
    }

    public boolean existsById(Long aLong) {
        return false;
    }

    public Iterable<PrimaryTransaction> findAll() {
        return null;
    }

    public Iterable<PrimaryTransaction> findAllById(Iterable<Long> longs) {
        return null;
    }

    public long count() {
        return 0;
    }

    public void deleteById(Long aLong) {

    }

    public void delete(PrimaryTransaction entity) {

    }

    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    public void deleteAll(Iterable<? extends PrimaryTransaction> entities) {

    }

    public void deleteAll() {

    }
}
