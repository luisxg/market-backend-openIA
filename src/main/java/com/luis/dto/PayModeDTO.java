package com.luis.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayModeDTO {
    private Integer idPayMode;
    private String name;
    private String details;
}
