package com.personal_finance_api.database.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String type;

    @Column(nullable = false)
    BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;

}
