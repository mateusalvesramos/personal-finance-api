package com.personal_finance_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotNull
    private BigDecimal balance;

    @NotNull
    private Integer user_id;
}
