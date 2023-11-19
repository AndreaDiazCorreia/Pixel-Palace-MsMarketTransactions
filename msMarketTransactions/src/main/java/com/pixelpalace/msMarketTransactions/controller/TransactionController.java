package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.dto.TransactionDTO;
import com.pixelpalace.msMarketTransactions.dto.TransactionListDto;
import com.pixelpalace.msMarketTransactions.service.ITransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final ITransactionService transactionService;

    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping("/ListTransaction")
    public ResponseEntity<TransactionListDto> getListTransaction() {

        TransactionListDto response = transactionService.getTransactionListDto();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransactiontById(@PathVariable Long id){
        return new ResponseEntity<TransactionDTO>(transactionService.getTransactionById(id), HttpStatus.OK);
    }


}
