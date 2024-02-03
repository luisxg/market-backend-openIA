package com.luis.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @Column(nullable = false, length = 20)
    private String barcode;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 5)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal price;

    @Column(nullable = false, length = 5)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int stock;

    @Column(nullable = false, length = 500)
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
//    @JsonIgnoreProperties("productList")
    private Category category;
}
