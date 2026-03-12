package com.example.demo.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.CartItem;

public interface CartService {
    public Cart getCartByUserId (Long userId);
    public CartItem addItemToCart (Long userId, Long productId, int quantity);
    public CartItem removeItemFromCart (Long userId, Long productId);
    public CartItem updateItemQuantity (Long userId, Long productId, int quantity);
    public Cart clearCart (Long userId);
}