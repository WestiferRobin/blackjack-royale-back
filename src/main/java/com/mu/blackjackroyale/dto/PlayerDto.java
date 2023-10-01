package com.mu.blackjackroyale.dto;

import java.math.BigDecimal;

public class PlayerDto {
    private String name;
    private BigDecimal balance;

    public PlayerDto(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getBalance() { return this.balance; }
    public void setBalance(BigDecimal lastName) { this.balance = balance; }

    @Override
    public String toString() {
        return this.getName();
    }
}
