package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "products_id")
    private Long productsId;

    @Column (name = "title",nullable = false)
    @NotBlank
    @Size (max = 250, message = "Must less than 250")
    @Nationalized
    private String title;

    @Column (name = "description")
    @Size (max = 1000, message = "description must be less then 1000 characters")
    @Nationalized
    private String description;

    @Column (name = "price", nullable = false)
    @DecimalMin(value = "0.0", inclusive = true, message = "price must be non-negative")
    @NotNull (message = "price is required")
    private BigDecimal price;

    @Column (name = "stock",nullable = false)
    @Min(value = 0, message = "stock must be non-negative")
    @NotNull (message = "stock is required")
    private Integer stock;

    @Column (name = "thumbnail")
    private String thumbnail;

}
