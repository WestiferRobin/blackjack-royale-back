package com.mu.blackjackroyale.model.player;

import com.mu.blackjackroyale.model.chips.ChipBet;
import com.mu.blackjackroyale.model.shoe.Shoe;

public class PrismPlayer extends Player {
    @Override
    public void playTurn(Player opponent, Shoe shoe) {

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
