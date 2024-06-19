package com.anup.productmanagement.service;

import com.anup.productmanagement.entity.Product;
import com.anup.productmanagement.model.ProductRequest;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductRequest request);

    List<Product> getAllProducts();

    Product editProduct(ProductRequest request);

    Product deleteProduct(Long id);
}
