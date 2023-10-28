package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.dto.ProductDTO;
import com.pixelpalace.msMarketTransactions.dto.ProductListDTO;
import com.pixelpalace.msMarketTransactions.dto.request.NewProductDTO;
import com.pixelpalace.msMarketTransactions.dto.request.ProductRequestDTO;
import com.pixelpalace.msMarketTransactions.util.CategoryTypeEnum;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {

    ProductListDTO getProducts();

    ProductListDTO getProducts(CategoryTypeEnum category);

    ProductDTO getProductById(Long Id);

    ProductListDTO getProductByName(String name);


}
