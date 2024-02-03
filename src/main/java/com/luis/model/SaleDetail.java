package com.luis.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSaleDetail;

    @ManyToOne
    @JoinColumn(name = "id_sale",nullable = false,foreignKey = @ForeignKey(name = "FK_DETAIL_SALE"))
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "id_product",nullable = false,foreignKey = @ForeignKey(name = "FK_DETAIL_PRODUCT"))
    private Product product;

    @Column(nullable = false, length = 4)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int quantity;

    @Column(nullable = false, length = 5)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal subTotal;
}
