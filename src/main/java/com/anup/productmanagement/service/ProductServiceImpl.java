package com.anup.productmanagement.service;

import com.anup.productmanagement.entity.Product;
import com.anup.productmanagement.model.ProductRequest;
import com.anup.productmanagement.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Override
    public Product addProduct(ProductRequest request) {
        Product product = Product.builder()
                .articleName(request.getArticleName())
                .quantity("1")
                .category(request.getCategory())
                .material(request.getMaterial())
                .carat(request.getCarat())
                .hallmarkId(request.getHallmarkId())
                .weight(request.getWeight())
                .materialCostPrice(request.getMaterialCostPrice())
                .articleCostPrice(setArticleCostPrice(request))
                .materialSellPrice(request.getMaterialSellPrice())
                .articleSellPrice(request.getArticleSellPrice())
                .articleMakingCostPrice(request.getArticleMakingCostPrice())
                .articleMakingSellPrice(request.getArticleMakingSellPrice())
                .articleMaterialPercentage(request.getArticleMaterialPercentage())
                .hallmark(request.isHallmark())
                .build();
        return productRepository.save(product);
    }

    private Double setArticleCostPrice(ProductRequest request) {
        return request.getWeight() * (request.getMaterialCostPrice()/10) * (request.getArticleMaterialPercentage()/100)
                +request.getArticleMakingCostPrice();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product editProduct(ProductRequest request) {
        Optional<Product> existingProduct = productRepository.findById(String.valueOf(request.getId()));
        Product updatedProduct = null;
        if(existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setArticleName(request.getArticleName());
            product.setQuantity(request.getQuantity());
            product.setCarat(request.getCategory());
            product.setMaterial(request.getMaterial());
            product.setCarat(request.getCarat());
            product.setHallmarkId(request.getHallmarkId());
            product.setWeight(request.getWeight());
            product.setMaterialCostPrice(request.getMaterialCostPrice());
            product.setArticleMakingCostPrice(request.getArticleMakingCostPrice());
            product.setArticleMaterialPercentage(request.getArticleMaterialPercentage());
            product.setArticleCostPrice(setArticleCostPrice(request));
            updatedProduct = productRepository.save(product);
        }
        return updatedProduct;
    }

    @Override
    public Product deleteProduct(Long id) {
        Optional<Product> existingProduct = productRepository.findById(String.valueOf(id));
        if(existingProduct.isPresent()) {
            productRepository.deleteById(String.valueOf(id));
            return existingProduct.get();
        }
        return null;
     }
}
