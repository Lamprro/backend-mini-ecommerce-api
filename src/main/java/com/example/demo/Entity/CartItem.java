package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "cart_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "cart_item_id")
    private Long cartItemId;

    @NotNull (message = "product is required")
    @JoinColumn (name = "products_id",nullable = false)
    @ManyToOne (fetch = FetchType.LAZY)
    private Products products;

    @Column (name = "quantity",nullable = false)
    @Min(value = 1, message = "quantity must be non-negative")
    @NotNull (message = "quantity is required")
    private int quantity;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "cart_id", nullable = false)
    private Cart cart;
}
