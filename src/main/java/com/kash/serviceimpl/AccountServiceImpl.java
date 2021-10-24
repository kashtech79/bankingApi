package com.kash.serviceimpl;

import com.kash.dao.PrimaryAccountDao;
import com.kash.dao.SavingsAccountDao;
import com.kash.entity.PrimaryAccount;
import com.kash.entity.PrimaryTransaction;
import com.kash.entity.SavingsAccount;
import com.kash.entity.SavingsTransaction;
import com.kash.service.AccountService;
import com.kash.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

@Service
public class AccountServiceImpl implements AccountService {

    private static int nextAccountNumber = 100001;

    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Autowired
    private SavingsAccountDao savingsAccountDao;

    @Autowired
    private TransactionService transactionService;


    @Transactional
    public PrimaryAccount createPrimaryAccount(PrimaryAccount primaryAccount) {
//        PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountNumber(primaryAccount.getAccountNumber());
        primaryAccount.setAccountBalance(primaryAccount.getAccountBalance());
        primaryAccountDao.save(primaryAccount);
        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }

    public SavingsAccount createSavingsAccount(SavingsAccount savingsAccount) {
//                PrimaryAccount primaryAccount = new PrimaryAccount();
        savingsAccount.setAccountNumber(savingsAccount.getAccountNumber());
        savingsAccount.setAccountBalance(savingsAccount.getAccountBalance());
        savingsAccountDao.save(savingsAccount);
        return savingsAccountDao.findByAccountNumber(savingsAccount.getAccountNumber());
    }

    @Transactional
    public void deposit(String accountType, Integer accountNumber, double amount) {

        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = primaryAccountDao.findByAccountNumber(accountNumber);
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().add(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryDepositTransaction(primaryTransaction);
        }
    }

    @Transactional
    public void depositSavings(String accountType, Integer accountNumber, double amount) {

        if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = savingsAccountDao.findByAccountNumber(accountNumber);
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().add(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
            transactionService.saveSavingsDepositTransaction(savingsTransaction);
        }
    }


    public SavingsAccount createSavingsAccount() {
        return null;
    }

    @Transactional
    public void withdraw(String accountType, Integer accountNumber, double amount) {

        if (accountType.equalsIgnoreCase("Primary")) {
            PrimaryAccount primaryAccount = primaryAccountDao.findByAccountNumber(accountNumber);
            primaryAccount.setAccountBalance(primaryAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            primaryAccountDao.save(primaryAccount);

            Date date = new Date();

            PrimaryTransaction primaryTransaction = new PrimaryTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, primaryAccount.getAccountBalance(), primaryAccount);
            transactionService.savePrimaryWithdrawTransaction(primaryTransaction);
        }
    }

    @Transactional
    public void withdrawSavings(String accountType, Integer accountNumber, double amount) {

        if (accountType.equalsIgnoreCase("Savings")) {
            SavingsAccount savingsAccount = savingsAccountDao.findByAccountNumber(accountNumber);
            savingsAccount.setAccountBalance(savingsAccount.getAccountBalance().subtract(new BigDecimal(amount)));
            savingsAccountDao.save(savingsAccount);

            Date date = new Date();

            SavingsTransaction savingsTransaction = new SavingsTransaction(date, "Deposit to Primary Account", "Account", "Finished", amount, savingsAccount.getAccountBalance(), savingsAccount);
            transactionService.saveSavingsWithdrawTransaction(savingsTransaction);
        }
    }

    private int accountGen() {
        return ++nextAccountNumber;
    }
}
