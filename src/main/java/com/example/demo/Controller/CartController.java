package com.example.demo.Controller;

import com.example.demo.Controller.DTO.AddToCartDTO;
import com.example.demo.Controller.DTO.CartItemRequest;
import com.example.demo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getCartByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }
    @PostMapping("/add")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartDTO addToCartDTO){
        for(CartItemRequest itemRequest : addToCartDTO.getItems()){
            cartService.addItemToCart(addToCartDTO.getUserId(),itemRequest.getProductId(),itemRequest.getQuantity());
        }
        return ResponseEntity.ok(cartService.getCartByUserId(addToCartDTO.getUserId()));
    }
    @PutMapping("/user/{userId}/products/{productsId}")
    public ResponseEntity<?> updateItemQuantity(@PathVariable Long userId, @PathVariable Long productsId, @RequestParam int quantity){
        return ResponseEntity.ok(cartService.updateItemQuantity(userId,productsId,quantity));
    }
    @DeleteMapping("/user/{userId}/products/{productsId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable Long userId, @PathVariable Long productsId){
        return ResponseEntity.ok(cartService.removeItemFromCart(userId,productsId));
    }
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<?> clearCart(@PathVariable Long userId){
        return ResponseEntity.ok(cartService.clearCart(userId));
    }
}
