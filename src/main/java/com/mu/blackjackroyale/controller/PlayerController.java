package com.mu.blackjackroyale.controller;

import com.mu.blackjackroyale.dto.PlayerDto;
import com.mu.blackjackroyale.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/player")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService service) {

        this.playerService = service;
    }

    @GetMapping("{id}")
    public ResponseEntity<PlayerDto> getPlayer(@PathVariable UUID id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("")
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("")
    public ResponseEntity<PlayerDto> addPlayer(@RequestBody PlayerDto newPlayer) {
        return playerService.addPlayer(newPlayer);
    }

}
