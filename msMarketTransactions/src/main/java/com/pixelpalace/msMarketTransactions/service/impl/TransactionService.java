package com.pixelpalace.msMarketTransactions.service.impl;

import com.pixelpalace.msMarketTransactions.model.Transaction;
import com.pixelpalace.msMarketTransactions.repository.ITransactionRepository;
import com.pixelpalace.msMarketTransactions.service.ITransactionService;
import io.micrometer.core.instrument.binder.db.MetricsDSLContext;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }
    @Override
    public Transaction findByRandomNumber(Long randomNumber) {
        return null;
    }
    @Override
    public Transaction updateTransaction(Transaction transaction) {
        return save(transaction);
    }
    @Override
    public Transaction save(Transaction transaction) {

        return transaction;
    }
    @Override
    public Transaction deleteById(Long id) {
        return null;
    }


}
