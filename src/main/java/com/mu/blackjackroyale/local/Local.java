package com.mu.blackjackroyale.local;

import com.mu.blackjackroyale.local.games.DebugGame;

public class Local {
    public static void main (String args[]) {
        var game = new DebugGame();
        while (!game.getDrawer().isEmpty()) {
            game.playRound();
        }
    }
}
