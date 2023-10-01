package com.mu.blackjackroyale.service;

import com.mu.blackjackroyale.componet.PlayerConverter;
import com.mu.blackjackroyale.dto.PlayerDto;
import com.mu.blackjackroyale.model.Player;
import com.mu.blackjackroyale.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        var players = playerRepository.findAll();
        var playerDtoList = new ArrayList<PlayerDto>();
        for (var player : players) {
            var convertedPlayer = PlayerConverter.playerToPlayerDto(player);
            playerDtoList.add(convertedPlayer);
        }
        return ResponseEntity.ok(playerDtoList);
    }

    @Override
    public ResponseEntity<PlayerDto> addPlayer(PlayerDto newPlayer) {
        var convertedPlayer = PlayerConverter.playerDtoToPlayer(newPlayer);
        var validPlayer = playerRepository.save(convertedPlayer);
        var convertedValidPlayer = PlayerConverter.playerToPlayerDto(validPlayer);
        return ResponseEntity.ok(convertedValidPlayer);
    }

    @Override
    public ResponseEntity<PlayerDto> getPlayerById(int playerId) {
        Optional<Player> playerOptional = playerRepository.findById(playerId);
        if (playerOptional.isPresent()) {
            var convertedPlayer = PlayerConverter.playerToPlayerDto(playerOptional.get());
            return ResponseEntity.ok(convertedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
