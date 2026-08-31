package com.personal_finance_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class AccountResponse {

    private Integer id;
    private String name;
    private String type;
    private BigDecimal balance;
    private Integer user_id;
}
