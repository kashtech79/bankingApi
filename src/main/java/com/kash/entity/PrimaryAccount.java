package com.kash.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

    @Entity
    @Getter
    @Setter
    @Table(name = "primary_account")
    public class PrimaryAccount {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private Integer accountNumber;
        private BigDecimal accountBalance;
//        @JsonIgnore
        @OneToMany(mappedBy = "primaryAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<PrimaryTransaction> primaryTransactionList;
    }
