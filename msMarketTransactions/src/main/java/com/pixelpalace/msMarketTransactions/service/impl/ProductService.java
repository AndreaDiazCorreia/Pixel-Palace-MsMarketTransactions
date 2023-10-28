package com.pixelpalace.msMarketTransactions.service.impl;

import com.pixelpalace.msMarketTransactions.dto.ProductDTO;
import com.pixelpalace.msMarketTransactions.dto.ProductListDTO;
import com.pixelpalace.msMarketTransactions.dto.request.NewProductDTO;
import com.pixelpalace.msMarketTransactions.dto.request.ProductRequestDTO;
import com.pixelpalace.msMarketTransactions.exception.EmptyProductsException;
import com.pixelpalace.msMarketTransactions.exception.CategoryNotFoundException;
import com.pixelpalace.msMarketTransactions.exception.PlatformNotFoundException;
import com.pixelpalace.msMarketTransactions.exception.ProductNotFoundException;
import com.pixelpalace.msMarketTransactions.model.Category;
import com.pixelpalace.msMarketTransactions.model.Platform;
import com.pixelpalace.msMarketTransactions.model.Product;
import com.pixelpalace.msMarketTransactions.repository.IProductRepository;
import com.pixelpalace.msMarketTransactions.service.ICategoryService;
import com.pixelpalace.msMarketTransactions.service.IPlatformService;
import com.pixelpalace.msMarketTransactions.service.IProductService;
import com.pixelpalace.msMarketTransactions.util.CategoryTypeEnum;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;
    private final ICategoryService categoryService;
    private final IPlatformService platformService;
    private ModelMapper modelMapper;

    public ProductService(IProductRepository productRepository, ICategoryService categoryService, IPlatformService platformService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.platformService = platformService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ProductListDTO getProducts() {
        final List<Product> products = productRepository.findAll();

        return createProductList(products);
    }

    @Override
    public ProductListDTO getProducts(CategoryTypeEnum category) {

        Category category1 = categoryService.findByName(category)
                .orElseThrow(()-> new CategoryNotFoundException("No existe la categoria"));

        final List<Product> products = productRepository.findByCategoryName(category1.getName());

        return createProductList(products);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            throw new ProductNotFoundException("No se ha encontrado el producto");
        }

        return productMapperToDTO(product);
    }

    @Override
    public ProductListDTO getProductByName(String keyword) {
        List<Product> products = productRepository.findByNameContaining(keyword);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("No se ha encontrado ningún producto");
        }

        return createProductList(products);
    }



    private ProductListDTO createProductList(final List<Product> products) {
        if (products.isEmpty()) {
            throw new EmptyProductsException("No se han encontrado productos");
        }

        List<ProductDTO> productDTO = products
                .stream()
                .map(product -> productMapperToDTO(product))
                .toList();

        return new ProductListDTO(productDTO);
    }

    private ProductDTO productMapperToDTO(final Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        productDTO.setCategories(product.getCategories().stream().map(Category::getName).toList());
        productDTO.setPlatforms(product.getPlatforms().stream().map(Platform::getName).toList());
        return productDTO;
    }

    private Product productMapperToModel(final NewProductDTO newProductDTO) {
        return Product.builder()
                .name(newProductDTO.getName())
                .description(newProductDTO.getDescription())
                .categories(newProductDTO.getCategoriesId().stream().map(catId -> categoryService.findById(catId).orElse(null)).toList())
                .platforms(newProductDTO.getPlatformsId().stream().map(platId -> platformService.findById(platId).orElse(null)).toList())
                .price(newProductDTO.getPrice())
                .build();
    }

    private void validations(List<Long> categoriesId, List<Long> platformsId){
        for (int i= 0; i<categoriesId.size(); i++) {
            if (categoryService.findById(categoriesId.get(i)).isEmpty()) {
                throw new CategoryNotFoundException("No se ha encontrado la categoria de Id " + categoriesId.get(i));
            }
        }

        for (int i= 0; i<platformsId.size(); i++) {
            if (platformService.findById(platformsId.get(i)).isEmpty()) {
                throw new PlatformNotFoundException("No se ha encontrado la plataforma de Id " + platformsId.get(i));
            }
        }
    }
}
