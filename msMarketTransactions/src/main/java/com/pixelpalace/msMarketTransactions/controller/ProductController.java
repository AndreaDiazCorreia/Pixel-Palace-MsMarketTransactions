package com.pixelpalace.msMarketTransactions.controller;

import com.pixelpalace.msMarketTransactions.dto.ProductDTO;
import com.pixelpalace.msMarketTransactions.dto.ProductListDTO;
import com.pixelpalace.msMarketTransactions.dto.request.NewProductDTO;
import com.pixelpalace.msMarketTransactions.dto.request.ProductRequestDTO;
import com.pixelpalace.msMarketTransactions.model.Product;
import com.pixelpalace.msMarketTransactions.service.IProductService;
import com.pixelpalace.msMarketTransactions.util.CategoryTypeEnum;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/games")
    public ResponseEntity<ProductListDTO> getProductsList(@RequestParam Optional<String> category){

        Optional<CategoryTypeEnum> productType = category.flatMap(CategoryTypeEnum::getCategoryType);

        ProductListDTO response;
        if(category.isPresent()) {
            response = productService.getProducts(productType.get());
        } else{
            response = productService.getProducts();
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        return new ResponseEntity<ProductDTO>(productService.getProductById(id), HttpStatus.OK);
    }

    @GetMapping("/games/{name}")
    public ResponseEntity<ProductListDTO> getProductByName(@PathVariable String name){
        return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.OK);
    }


}
