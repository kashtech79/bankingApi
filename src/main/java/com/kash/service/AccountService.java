package com.kash.service;

import com.kash.entity.PrimaryAccount;
import com.kash.entity.SavingsAccount;

public interface AccountService {
    PrimaryAccount createPrimaryAccount(PrimaryAccount primaryAccount);
    SavingsAccount createSavingsAccount(SavingsAccount savingsAccount);
    void deposit(String accountType, Integer accountNumber, double amount);
    void withdraw(String accountType, Integer accountNumber, double amount);
    void depositSavings(String accountType, Integer accountNumber, double amount);
    void withdrawSavings(String accountType, Integer accountNumber, double amount);

}
