package com.example.demo.Service;

import com.example.demo.Entity.Products;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface ProductService {
    public Page<Products> getAllProducts(Pageable pageable);
    public 
}
