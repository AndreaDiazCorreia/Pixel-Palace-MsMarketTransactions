package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.dto.TransactionDTO;
import com.pixelpalace.msMarketTransactions.dto.TransactionListDto;
import com.pixelpalace.msMarketTransactions.dto.request.NewTransactionDTO;
import com.pixelpalace.msMarketTransactions.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {


    private final ITransactionService transactionService;
    @Autowired
    public TransactionController(ITransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("/createTransaction")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody NewTransactionDTO newTransactionDTO) {
        // Puedes agregar validaciones adicionales si es necesario

        // Aquí llamamos al servicio para crear la transacción
        TransactionDTO createdTransaction = transactionService.createTransaction(newTransactionDTO);

        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);

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

