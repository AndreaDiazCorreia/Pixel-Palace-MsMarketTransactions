package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.model.Transaction;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {
    Transaction findByRandomNumber(Long randomNumber);

    Transaction createTransaction(Transaction transaction);

    Transaction updateTransaction(Transaction transaction);

    Transaction save(Transaction transaction);
    Transaction deleteById (Long id);
}

