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
public class ReportDTO {
    private String name;
    private Double stock;
    private  List<String> categories;
}
