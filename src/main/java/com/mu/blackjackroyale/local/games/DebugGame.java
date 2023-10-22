package com.mu.blackjackroyale.local.games;

import com.mu.blackjackroyale.local.chips.Chip;
import com.mu.blackjackroyale.local.drawer.shoe.DebugShoe;
import com.mu.blackjackroyale.local.player.Dealer;
import com.mu.blackjackroyale.local.player.UserPlayer;

import java.util.List;

public class DebugGame extends Game {
    public DebugGame() {
        super(
            Chip.Red.getValue(),
            Chip.Purple.getValue(),
            new DebugShoe(),
            new Dealer(),
            List.of(new UserPlayer())
        );
    }
}
