package com.mu.blackjackroyale.local.player;

import com.mu.blackjackroyale.local.chips.ChipBet;
import com.mu.blackjackroyale.local.drawer.Drawer;

/*
- Dealers
    - only hit and stand
    - rules:
        - keep hitting until 17+
        - stand at 17
* * */
public class Dealer extends Player {
    @Override
    public void playTurn(Player opponent, Drawer drawer) {
        for (var card : this.getHand()) {
            if (card.isFaceDown()) card.flip();
        }
        // keep getting more cards until 17+
        int handResults = this.calculateHandValue();
        while (handResults < 17) {
            var card = drawer.dealCard();
            this.receiveCard(card);
            handResults = this.calculateHandValue();
        }
    }

    @Override
    public ChipBet placeBet(int minValue, int maxValue) {
        return null;
    }

    @Override
    public String toString() {
        return "Dealer: " + super.toString();
    }
}
