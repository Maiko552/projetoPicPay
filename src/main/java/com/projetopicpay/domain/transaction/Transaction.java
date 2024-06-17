package com.projetopicpay.domain.transaction;

import com.projetopicpay.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions") //plural pq é palavra reservado em MYSQL
@Table(name = "transactions")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne //Usuario pode ter muitas transações mas a transação é vinculada a UM
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne //Receiver pode receber muitas transações mas a transação é vinculada a UM
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;


}
