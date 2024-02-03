package com.luis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSale;

    @Column(nullable = false)
    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_CLIENT"))
    private Client client;

    @OneToMany(mappedBy = "sale", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<SaleDetail> detailList;

    @ManyToOne
    @JoinColumn(name = "id_pay_mode", nullable = false, foreignKey = @ForeignKey(name = "FK_SALE_PAYMODE"))
    private PayMode payMode;

    @Column(nullable = false)
    private BigDecimal total;

}
