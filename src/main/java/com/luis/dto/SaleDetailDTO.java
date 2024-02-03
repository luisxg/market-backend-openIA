package com.luis.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.luis.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDetailDTO {
    private Integer idSaleDetail;
    @JsonBackReference
    private SaleDTO sale;
    private Product product;
    private int quantity;
    private BigDecimal subTotal;
}
