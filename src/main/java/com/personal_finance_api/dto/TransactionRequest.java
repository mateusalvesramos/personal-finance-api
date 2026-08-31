package com.personal_finance_api.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class TransactionRequest {

    private String description;
    private BigDecimal amount;
    private LocalDateTime date;
    private String type;
    private Integer account_id;
}
