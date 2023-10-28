package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.model.Category;
import com.pixelpalace.msMarketTransactions.model.Product;
import com.pixelpalace.msMarketTransactions.util.CategoryTypeEnum;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ICategoryService {

   Optional<Category> findByName(CategoryTypeEnum category);

   Optional<Category> findById(Long id);

   Category saveProduct(Long categoryId, Product product);
}
