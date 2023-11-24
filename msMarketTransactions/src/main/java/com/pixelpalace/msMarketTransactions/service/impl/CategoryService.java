package com.pixelpalace.msMarketTransactions.service.impl;

import com.pixelpalace.msMarketTransactions.exception.CategoryNotFoundException;
import com.pixelpalace.msMarketTransactions.model.Category;
import com.pixelpalace.msMarketTransactions.model.Product;
import com.pixelpalace.msMarketTransactions.repository.ICategoryRepository;
import com.pixelpalace.msMarketTransactions.service.ICategoryService;
import com.pixelpalace.msMarketTransactions.util.CategoryTypeEnum;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository genreRepository) {
        this.categoryRepository = genreRepository;
    }

    @Override
    public Optional<Category> findByName(CategoryTypeEnum category) {
        return categoryRepository.findByName(category.getDescription());
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }
    @Override
    public Category saveProduct(Long categoryId, Product product) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            List<Product> products = new ArrayList<>(category.getProducts());
            products.add(product);
            category.setProducts(products);
            categoryRepository.save(category);
        } else {
        throw new CategoryNotFoundException("No se ha encontrado la categoria de Id " + categoryId);
    }
        return category;
    }
}
