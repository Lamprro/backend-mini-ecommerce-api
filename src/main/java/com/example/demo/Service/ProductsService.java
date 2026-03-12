package com.example.demo.Service;

import com.example.demo.Entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductsService {
    public Page<Products> getAllProducts (Pageable pageable);
    public Products getProductsById (Long id);
}
