package com.mu.blackjackroyale.local.chips;

public enum Chip {
    White(1),
    Red(5),
    Blue(10),
    Grey(20),
    Green(25),
    Orange(50),
    Black(100),
    Pink(250),
    Purple(500),
    Yellow(1000),
    LightBlue(2000),
    Brown(5000)
    ;

    private int chipValue;
    Chip(int chipValue) {
        this.chipValue = chipValue;
    }

    public int getValue() {
        return this.chipValue;
    }
}
