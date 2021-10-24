package com.kash.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavingsAccountDto {
    private double amount;
    private Integer accountNumber;
    private String accountType;
}
