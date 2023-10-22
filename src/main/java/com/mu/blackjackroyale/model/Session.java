package com.mu.blackjackroyale.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private UUID sessionId;
}
