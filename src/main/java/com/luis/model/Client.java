package com.luis.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(nullable = false,length = 10)
    private String firstName;

    @Column(nullable = false,length = 10)
    private String lastName;

    @Column(length = 50)
    private String address;

    @Column(nullable = false,length = 10)
    private String phone;

    @Column(nullable = false,length = 20)
    private String email;

    @Column(nullable = false,length = 10)
    private String dni;

}













