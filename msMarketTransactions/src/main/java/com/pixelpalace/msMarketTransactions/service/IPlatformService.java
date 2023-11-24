package com.pixelpalace.msMarketTransactions.service;

import com.pixelpalace.msMarketTransactions.model.Category;
import com.pixelpalace.msMarketTransactions.model.Platform;
import com.pixelpalace.msMarketTransactions.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IPlatformService {

    Optional<Platform> findById(Long id);
    List<Platform> getPlatform();

    Platform saveProduct(Long platformId, Product product);
}
