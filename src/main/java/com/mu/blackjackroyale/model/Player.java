package com.mu.blackjackroyale.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private int playerId;

    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_balance")
    private BigDecimal balance;

    // Constructors, getters, setters, and other methods

    // Default constructor
    public Player() {
    }

    // Constructor with parameters
    public Player(String playerName, BigDecimal balance) {
        this.playerName = playerName;
        this.balance = balance;
    }

    // Getter and Setter methods
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // Other methods as needed
}
