package com.example.demo.Service;

import com.example.demo.Entity.Cart;
import com.example.demo.Entity.CartItem;
import com.example.demo.Entity.Products;
import com.example.demo.Exception.InsufficientException;
import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.Repository.CartItemRepository;
import com.example.demo.Repository.CartRepository;
import com.example.demo.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public Cart getCartByUserId(Long userId) {
        return cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    Cart newCart = new Cart(userId);
                    return cartRepository.save(newCart);
                });
    }

    @Transactional
    @Override
    public CartItem addItemToCart(Long userId, Long productId, int quantity) {
        Cart cart = getCartByUserId(userId);

        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product not found with id: " + productId));

        int productStock = products.getStock();
        if (quantity > productStock) {
            throw new InsufficientException("insufficient stock for product with id: " + productId);
        }

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProducts().getProductsId().equals(productId))
                .findFirst();
        CartItem cartItem;
        if (existingItem.isPresent()) {
            cartItem = existingItem.get();
            if (quantity + cartItem.getQuantity() > productStock) {
                throw new InsufficientException("insufficient stock for product with id: " + productId);
            }
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new CartItem();
            cartItem.setProducts(products);
            cartItem.setQuantity(quantity);
            cartItem.setCart(cart);
            cart.getItems().add(cartItem);
        }

        return cartItemRepository.save(cartItem);
    }

    @Transactional
    @Override
    public CartItem removeItemFromCart(Long userId, Long productId) {
        Cart cart = getCartByUserId(userId);

        CartItem itemToRemove = cart.getItems().stream()
                .filter(item -> item.getProducts().getProductsId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("cart item not found"));
        cart.getItems().remove(itemToRemove);

        cartItemRepository.delete(itemToRemove);
        return itemToRemove;
    }

    @Transactional
    @Override
    public CartItem updateItemQuantity(Long userId, Long productId, int newQuantity) {
        Cart cart = getCartByUserId(userId);

        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProducts().getProductsId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("cart item not found"));

        Products products = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product not found with id: " + productId));

        if (newQuantity > products.getStock()) {
            throw new InsufficientException("insufficient stock for product with id: " + productId);
        }

        cartItem.setQuantity(newQuantity);
        return cartItemRepository.save(cartItem);
    }

@Transactional
@Override
public Cart clearCart(Long userId) {
    Cart cart = getCartByUserId(userId);

    for (CartItem item : cart.getItems()) {
        Products products = item.getProducts();
        products.setStock(products.getStock() + item.getQuantity());
        productsRepository.save(products);
    }
    cartItemRepository.deleteAll(cart.getItems());
    cart.getItems().clear();
    return cartRepository.save(cart);
}
}

