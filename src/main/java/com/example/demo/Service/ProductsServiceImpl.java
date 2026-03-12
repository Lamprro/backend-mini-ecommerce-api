package com.example.demo.Service;

import com.example.demo.Entity.Products;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public Page<Products> getAllProducts(Pageable pageable) {
        return productsRepository.findAll(pageable);
    }

    @Override
    public Products getProductsById(Long id) {
        return productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found with ID: " + id));
    }
}
