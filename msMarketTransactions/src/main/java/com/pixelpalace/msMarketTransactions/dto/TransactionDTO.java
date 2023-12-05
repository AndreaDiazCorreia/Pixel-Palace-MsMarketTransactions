package com.pixelpalace.msMarketTransactions.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private Long id;
    private String status;
    private String code;
    private Long  userId;
    private List<String> productId;
    private List<String> platformId;
    private String  date;
}