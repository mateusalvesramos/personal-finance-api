package com.personal_finance_api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ErrorResponse {

    private String message;
    private Integer status;
}
