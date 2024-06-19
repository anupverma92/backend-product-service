package com.anup.productmanagement.controller;

import com.anup.productmanagement.entity.Product;
import com.anup.productmanagement.model.ProductRequest;
import com.anup.productmanagement.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/v1")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody ProductRequest request) {
        return productService.addProduct(request);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("/editProduct")
    public Product getAllProducts(@RequestBody ProductRequest request){
        return productService.editProduct(request);
    }

    @DeleteMapping("deleteProduct/{productId}")
    public Product deleteProduct(@PathVariable("productId") Long id){
        return productService.deleteProduct(id);
    }
}
