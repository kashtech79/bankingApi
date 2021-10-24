package com.kash.controller;

import com.kash.dto.AccountDto;
import com.kash.dto.SavingsAccountDto;
import com.kash.entity.PrimaryAccount;
import com.kash.entity.SavingsAccount;
import com.kash.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/primary")
    public ResponseEntity<Object> primaryAccount(@RequestBody PrimaryAccount primaryAccount){
        accountService.createPrimaryAccount(primaryAccount);
        return ResponseEntity.ok("Record has been created");

    }
    @PostMapping("/savings")
    public ResponseEntity<Object> savingsAccount(@RequestBody SavingsAccount savingsAccount){
        accountService.createSavingsAccount(savingsAccount);
        return ResponseEntity.ok("Record has been created");

    }

    @PostMapping("/deposit")
    public ResponseEntity<Object> depositPost(@RequestBody AccountDto accountDto){
        accountService.deposit(accountDto.getAccountType(), accountDto.getAccountNumber(), accountDto.getAmount());
        return ResponseEntity.ok("Record has been entered");
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Object> withdrawPost(@RequestBody AccountDto accountDto){
        accountService.deposit(accountDto.getAccountType(), accountDto.getAccountNumber(), accountDto.getAmount());
        return ResponseEntity.ok("Record has been entered");
    }

    @PostMapping("/sdeposit")
    public ResponseEntity<Object> depositSavings(@RequestBody SavingsAccountDto savingsAccountDto){
        accountService.depositSavings(savingsAccountDto.getAccountType(), savingsAccountDto.getAccountNumber(), savingsAccountDto.getAmount());
        return ResponseEntity.ok("Record has been entered");
    }

    @PostMapping("/swithdraw")
    public ResponseEntity<Object> withdrawSavings(@RequestBody SavingsAccountDto savingsAccountDto){
        accountService.withdrawSavings(savingsAccountDto.getAccountType(), savingsAccountDto.getAccountNumber(), savingsAccountDto.getAmount());
        return ResponseEntity.ok("Record has been entered");
    }

}
