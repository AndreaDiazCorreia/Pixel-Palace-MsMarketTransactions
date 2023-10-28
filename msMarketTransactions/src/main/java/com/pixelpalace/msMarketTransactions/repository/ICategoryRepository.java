package com.pixelpalace.msMarketTransactions.repository;

import com.pixelpalace.msMarketTransactions.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String category);
    Optional<Category> findById(Long id);
}
