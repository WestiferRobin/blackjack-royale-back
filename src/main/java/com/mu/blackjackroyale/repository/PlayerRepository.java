package com.mu.blackjackroyale.repository;

import com.mu.blackjackroyale.model.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // Custom query methods can be defined here if needed
}
