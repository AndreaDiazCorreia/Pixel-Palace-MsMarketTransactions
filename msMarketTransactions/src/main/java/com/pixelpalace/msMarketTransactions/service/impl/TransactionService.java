package com.pixelpalace.msMarketTransactions.service.impl;

import com.pixelpalace.msMarketTransactions.dto.TransactionDTO;
import com.pixelpalace.msMarketTransactions.dto.TransactionListDto;
import com.pixelpalace.msMarketTransactions.model.Platform;
import com.pixelpalace.msMarketTransactions.model.Product;
import com.pixelpalace.msMarketTransactions.model.Transaction;
import com.pixelpalace.msMarketTransactions.repository.ITransactionRepository;
import com.pixelpalace.msMarketTransactions.service.ITransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService implements ITransactionService {

    private final ITransactionRepository iTransactionRepository;
    private final ModelMapper modelMapper;

    public TransactionService(ITransactionRepository iTransactionRepository) {
        this.iTransactionRepository = iTransactionRepository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public TransactionListDto getTransactionListDto() {
        List<Transaction> transactions = iTransactionRepository.findAll();
        return createTransactionList(transactions);
    }

    @Override
    public TransactionDTO getTransactionById(Long Id) {
        Transaction transaction = iTransactionRepository.findById(Id).orElse(null);

        if (transaction == null) {
            // Puedes lanzar una excepción aquí si prefieres.
            return null;
        }

        return transactionMapperToDTO(transaction);
    }

    private TransactionListDto createTransactionList(List<Transaction> transactions) {
        if (transactions.isEmpty()) {
            // Puedes lanzar una excepción aquí si prefieres.
            return null;
        }

        List<TransactionDTO> transactionDTOList = transactions
                .stream()
                .map(this::transactionMapperToDTO)
                .collect(Collectors.toList());

        return new TransactionListDto(transactionDTOList);
    }
    private TransactionDTO transactionMapperToDTO(final Transaction transaction) {
        TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
        transactionDTO.setProducts(transaction.getProducts().stream().map(Product:: getName).collect(Collectors.toList()));
        transactionDTO.setPlatform(transaction.getPlatform().stream().map(Platform::getName).collect(Collectors.toList()));
        return transactionDTO;
    }
}
