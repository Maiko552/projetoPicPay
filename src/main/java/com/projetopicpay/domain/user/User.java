package com.projetopicpay.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Entity(name = "users") //plural pq é palavra reservado em MYSQL
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode(of = "id") //chave primaria
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance; //Saldo do usuario

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
