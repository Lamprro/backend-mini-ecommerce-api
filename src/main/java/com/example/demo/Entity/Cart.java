package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table (name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "cart_id")
    private long cartId;

    @Column (name = "user_id",nullable = false, unique = true)
    private Long userId;

    @OneToMany (mappedBy = "cart",orphanRemoval = true ,cascade = CascadeType.ALL)
    private List<CartItem> items;

    public Cart (Long userId){
        this.userId=userId;
    }
}
