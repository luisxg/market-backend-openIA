package com.luis.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.luis.model.Client;
import com.luis.model.PayMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    private Integer idSale;
    private LocalDateTime saleDate;
    private Client client;
    @JsonManagedReference
    private List<SaleDetailDTO> detailList;
    private PayMode payMode;
    private BigDecimal total;
}
