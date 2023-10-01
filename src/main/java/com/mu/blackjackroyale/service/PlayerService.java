package com.mu.blackjackroyale.service;

import com.mu.blackjackroyale.dto.PlayerDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlayerService {
    ResponseEntity<PlayerDto> getPlayerById(int id);
    ResponseEntity<List<PlayerDto>> getAllPlayers();

    ResponseEntity<PlayerDto> addPlayer(PlayerDto newPlayer);
}
