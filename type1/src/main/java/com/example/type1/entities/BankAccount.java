package com.example.type1.entities;

import com.example.type1.enums.AccountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id

    private String id;  // Utilisation de Long pour l'ID

    private Date createdAt;
    private Double balance;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;  // Utilisation d'une énumération pour le type

    @ManyToOne
    private Customer customer;
}

