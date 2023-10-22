package com.mu.blackjackroyale.model.player;

import com.mu.blackjackroyale.model.chips.ChipBet;
import com.mu.blackjackroyale.model.shoe.Shoe;

/*
- Dealers
    - only hit and stand
    - rules:
        - keep hitting until 17+
        - stand at 17
* * */
public class Dealer extends Player {
    @Override
    public void playTurn(Player opponent, Shoe shoe) {
        for (var card : this.getHand()) {
            if (card.isFaceDown()) card.flip();
        }
        // keep getting more cards until 17+
        int handResults = this.calculateHandValue();
        while (handResults < 17) {
            var card = shoe.dealCard();
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
