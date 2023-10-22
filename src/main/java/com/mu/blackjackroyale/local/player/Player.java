package com.mu.blackjackroyale.local.player;

import com.mu.blackjackroyale.local.chips.ChipBank;
import com.mu.blackjackroyale.local.chips.ChipBet;
import com.mu.blackjackroyale.local.drawer.Drawer;
import com.mu.blackjackroyale.local.drawer.cards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Players:
    - UserPlayers
        - can hit, stand, double and split
        - rules:
            - awaits user input
    - PrismPlayers
        - can hit, stand, double and split
        - rules:
            - uses basic strategy
            - note that use the data for tensorflow model for betting
*/

public abstract class Player {

    private UUID Id;
    public UUID getId() { return this.Id; }
    private List<Card> hand = new ArrayList<>();
    public List<Card> getHand() { return this.hand; }

    private ChipBank chipBank = new ChipBank();
    public ChipBank getChipBank() { return this.chipBank; }

    public Player() {
        this.Id = UUID.randomUUID();
    }

    @Override
    public String toString() {
        var result = new ArrayList<String>();
        for (var card : this.getHand()) {
            result.add(card.toString());
        }
        return result.toString() + " => " + calculateHandValue();
    }

    public void receiveCard(Card card) {
        this.hand.add(card);
    }

    public int calculateHandValue() {
        var hand = this.getHand();

        int value = 0;
        int numAces = 0;

        for (var card : hand) {
            value += card.getRawValue();
            if (card.getValue() == "A") {
                numAces++;
            }
        }

        while (numAces > 0 && value > 21) {
            value -= 10;
            numAces--;
        }

        return value;
    }

    public void clearHand() {
        this.hand.clear();
    }

    abstract public void playTurn(Player opponent, Drawer drawer);

    abstract public ChipBet placeBet(int minValue, int maxValue);

    public void acceptEarnings(ChipBet bet) {
        this.getChipBank().addChips(bet);
    }
}
