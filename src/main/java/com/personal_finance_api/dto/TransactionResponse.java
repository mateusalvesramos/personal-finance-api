package com.personal_finance_api.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class TransactionResponse {

    private Integer id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime date;
    private String type;
    private Integer account_id;
}
