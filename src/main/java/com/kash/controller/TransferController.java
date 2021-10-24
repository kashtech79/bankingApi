package com.kash.controller;

import com.kash.entity.Recipient;
import com.kash.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransferController {

    @Autowired
    private TransactionService transactionService;

//    @GetMapping("/betweenaccounts")
//    public String recipientPost(@RequestBody Recipient recipient){
//        transactionService.saveRecipient(recipient);
//    }

}
