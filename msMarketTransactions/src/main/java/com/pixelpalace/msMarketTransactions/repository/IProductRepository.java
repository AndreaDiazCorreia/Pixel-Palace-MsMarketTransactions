package com.pixelpalace.msMarketTransactions.repository;

import com.pixelpalace.msMarketTransactions.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findById(Long id);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keyword%")
    List<Product> findByNameContaining(@Param("keyword") String keyword);

    Optional<Product> findByNameIgnoreCase(String name);

    List<Product> findAll();

    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.name = :categoryName")
    List<Product> findByCategoryName(@Param("categoryName") String categoryName);

    Product save(Product product);
}
