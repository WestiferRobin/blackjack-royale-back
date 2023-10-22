package com.mu.blackjackroyale.local.drawer.cards;

public class Card {
    private String value;
    public String getValue() {
        if (this.isFaceDown) return "X";
        return this.value;
    }

    private String suit;
    public String getSuit() {
        if (this.isFaceDown) return "X";
        return this.suit;
    }

    private int rawValue;
    public int getRawValue() {
        if (this.isFaceDown) return 0;
        return this.rawValue;
    }

    private boolean isFaceDown  = false;
    public boolean isFaceDown() { return this.isFaceDown; }
    public void flip() { this.isFaceDown = !this.isFaceDown; }

    public Card(String value, String suit) {
        this.value = value;
        this.suit = suit;
        this.rawValue = CardConstants.getRawValue(this.value);
    }

    public Card(String value, String suit, int rawValue) {
        this.value = value;
        this.suit = suit;
        this.rawValue = rawValue;
    }

    @Override
    public String toString() {
        return this.getValue() + ":" + this.getSuit();
    }
}
