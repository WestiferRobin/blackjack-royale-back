package com.mu.blackjackroyale.service;

import com.mu.blackjackroyale.dto.PlayerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PlayerService {
    ResponseEntity<PlayerDto> getPlayerById(UUID id);
    ResponseEntity<List<PlayerDto>> getAllPlayers();

    ResponseEntity<PlayerDto> addPlayer(PlayerDto newPlayer);
}
