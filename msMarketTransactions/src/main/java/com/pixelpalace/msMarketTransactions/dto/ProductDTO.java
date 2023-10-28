package com.pixelpalace.msMarketTransactions.dto;

import com.pixelpalace.msMarketTransactions.model.Category;
import com.pixelpalace.msMarketTransactions.model.Platform;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private List<String> categories;
    private List<String> platforms;
    private Double price;
}
