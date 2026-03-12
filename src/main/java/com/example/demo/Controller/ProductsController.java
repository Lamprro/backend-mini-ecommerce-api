package com.example.demo.Controller;

import com.example.demo.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(@RequestParam(defaultValue = "12") int limit, @RequestParam(defaultValue = "0") int skip){
        int page = skip/limit;
        Pageable pageable = Pageable.ofSize(limit).withPage(page);
        return ResponseEntity.ok(productsService.getAllProducts(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductsById(@PathVariable Long id){
        return ResponseEntity.ok(productsService.getProductsById(id));
    }
}
