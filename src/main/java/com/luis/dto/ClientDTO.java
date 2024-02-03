package com.luis.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Integer idClient;

    private String firstName;

    private String lastName;

    private String address;

    private String phone;

    private String email;

    private String dni;
}
