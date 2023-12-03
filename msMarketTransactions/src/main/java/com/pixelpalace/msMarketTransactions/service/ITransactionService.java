package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.dto.TransactionDTO;
import com.pixelpalace.msMarketTransactions.dto.TransactionListDto;
import com.pixelpalace.msMarketTransactions.dto.request.NewTransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface ITransactionService {

    TransactionListDto getTransactionListDto();

    TransactionDTO getTransactionById(Long Id);
    TransactionDTO createTransaction(NewTransactionDTO newTransactionDTO);

}
