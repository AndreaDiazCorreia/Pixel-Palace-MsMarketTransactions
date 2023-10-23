package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.model.Category;
import com.pixelpalace.msMarketTransactions.util.CategoryTypeEnum;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public interface ICategoryService {

   Optional<Category> findByName(CategoryTypeEnum category);
}
