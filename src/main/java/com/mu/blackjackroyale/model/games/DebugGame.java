package com.mu.blackjackroyale.model.games;

import com.mu.blackjackroyale.enums.Chip;
import com.mu.blackjackroyale.model.player.Dealer;
import com.mu.blackjackroyale.model.player.UserPlayer;
import com.mu.blackjackroyale.model.shoe.OneDeckShoe;

import java.util.List;

public class DebugGame extends Game {
    public DebugGame() {
        super(
            Chip.Red.getValue(),
            Chip.Purple.getValue(),
            new OneDeckShoe(),
            new Dealer(),
            List.of(new UserPlayer())
        );
    }
}
