package com.pixelpalace.msMarketTransactions.service.impl;

import com.pixelpalace.msMarketTransactions.exception.PlatformNotFoundException;
import com.pixelpalace.msMarketTransactions.model.Platform;
import com.pixelpalace.msMarketTransactions.model.Product;
import com.pixelpalace.msMarketTransactions.repository.IPlatformRepository;
import com.pixelpalace.msMarketTransactions.service.IPlatformService;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlatformService implements IPlatformService {

    private final IPlatformRepository platformRepository;

    public PlatformService(IPlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public Optional<Platform> findById(Long id) {
        return platformRepository.findById(id);
    }

    @Override
    public Platform saveProduct(Long platformId, Product product) {
        Platform platform = platformRepository.findById(platformId).orElse(null);
        if (platform != null) {
            List<Product> products = new ArrayList<>(platform.getProducts());
            products.add(product);
            platform.setProducts(products);
            platformRepository.save(platform);
        } else {
            throw new PlatformNotFoundException("No se ha encontrado la plataforma de Id " + platformId);
        }
        return platform;
    }
}
