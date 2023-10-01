package com.mu.blackjackroyale.componet;
import com.mu.blackjackroyale.dto.PlayerDto;
import com.mu.blackjackroyale.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerConverter {

    public static PlayerDto playerToPlayerDto(Player player) {
        return new PlayerDto(player.getPlayerName(), player.getBalance());
    }

    public static Player playerDtoToPlayer(PlayerDto playerDto) {
        Player player = new Player();
        player.setPlayerName(playerDto.getName());
        player.setBalance(playerDto.getBalance());
        // Add any additional mapping logic here
        return player;
    }
}

