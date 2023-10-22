package com.mu.blackjackroyale.local.player;

import com.mu.blackjackroyale.local.chips.ChipBet;
import com.mu.blackjackroyale.local.drawer.Drawer;

public class PrismPlayer extends Player {
    @Override
    public void playTurn(Player opponent, Drawer drawer) {

    }

    @Override
    public ChipBet placeBet(int minValue, int maxValue) {
        return null;
    }

    @Override
    public String toString() {
        return "Prism: " + super.toString();
    }
}
