package com.mu.blackjackroyale.model.player;

import com.mu.blackjackroyale.model.chips.ChipBank;
import com.mu.blackjackroyale.model.chips.ChipBet;
import com.mu.blackjackroyale.model.cards.Card;
import com.mu.blackjackroyale.model.shoe.Shoe;
import jakarta.persistence.*;

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

@Entity
@Table(name = "players")
public abstract class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private UUID Id;
    public UUID getId() { return this.Id; }

    @Column(name = "name")
    private String name;
    public String getName() { return this.name; }

    private List<Card> hand;
    public List<Card> getHand() { return this.hand; }

    private ChipBank chipBank = new ChipBank();
    public ChipBank getChipBank() { return this.chipBank; }

    public Player() {
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

    abstract public void playTurn(Player opponent, Shoe shoe);

    abstract public ChipBet placeBet(int minValue, int maxValue);

    public void acceptEarnings(ChipBet bet) {
        this.getChipBank().addChips(bet);
    }
}
