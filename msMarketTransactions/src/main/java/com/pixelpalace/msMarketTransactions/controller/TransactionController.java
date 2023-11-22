package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.model.Transaction;
import com.pixelpalace.msMarketTransactions.service.ITransactionService;
import jakarta.persistence.Id;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {

        Long randomNumber = (long) (Math.random() * 100000);

        Transaction existingTransaction = transactionService.findByRandomNumber(randomNumber);
        Transaction updateTransaction = transactionService.updateTransaction(transaction);

        if (existingTransaction == null) {
            transaction.setRandomNumber(randomNumber);
        } else {

            randomNumber = (long) (Math.random() * 100000);
            transaction.setRandomNumber(randomNumber);
        }


        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }
}
