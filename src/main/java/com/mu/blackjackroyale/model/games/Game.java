package com.mu.blackjackroyale.model.games;

import com.mu.blackjackroyale.model.chips.ChipBet;
import com.mu.blackjackroyale.model.player.Dealer;
import com.mu.blackjackroyale.model.player.Player;
import com.mu.blackjackroyale.model.shoe.Shoe;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Game {

    private Dealer dealer;
    public Dealer getDealer() { return this.dealer; }
    private List<Player> players;
    public List<Player> getPlayers() { return this.players; }
    private Shoe shoe;
    public Shoe getShoe() { return this.shoe; }
    private Map<UUID, ChipBet> bets = new Hashtable<>();
    public Map<UUID, ChipBet> getBets() { return this.bets; }

    private int minBet;
    public int getMinBet() { return this.minBet; }

    private int maxBet;
    public int getMaxBet() { return this.maxBet; }

    public Game(
        int minBet,
        int maxBet,
        Shoe shoe,
        Dealer dealer,
        List<Player> players
    ) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.shoe = shoe;
        this.dealer = dealer;
        this.players = players;
    }

    public void playRound() {
        // Players make bets
        placeBets();

        // deal hands to players and dealer
        dealHands();

        // show game table
        printGame();

        // Play turns
        handleTurns();

        // show game table
        printGame();

        // define winners and losers
        handleEarnings();

        // clear round
        clearRound();
    }

    private void printGame() {
        System.out.println();
        System.out.println(this.getDealer());
        for (var player : this.getPlayers()) {
            System.out.println(player);
        }
        System.out.println();
    }

    private void clearRound() {
        // clear hands
        for (var player : this.getPlayers()) {
            player.clearHand();
        }
        this.getDealer().clearHand();

        // clear bets
        var keys = this.getBets().keySet();
        for (var key : keys) {
            this.getBets().remove(key);
        }
    }

    private void placeBets() {
        // players place bets
        for (var player : this.getPlayers()) {
            // player places chips to bet
            // give it to the bets and then handle who wins
            var playerBet = player.placeBet(this.getMinBet(), this.getMaxBet());
            var betValue = playerBet.calculateBetValue();
//            while (betValue < getMinBet() || getMaxBet() < betValue) {
//                player.acceptEarnings(playerBet);
//                playerBet = player.placeBet();
//                betValue = playerBet.calculateBetValue();
//            }
            this.getBets().put(player.getId(), playerBet);
        }
    }

    private void dealHands() {
        for (int times = 0; times < 2; times++) {
            for (var player : this.getPlayers()) {
                var card = this.getShoe().dealCard();
                player.receiveCard(card);
            }
            var card = this.getShoe().dealCard();
            if (times == 1) {
                card.flip();
            }
            this.getDealer().receiveCard(card);
        }
    }

    private void handleTurns() {
        // players make turn
        playersTurn();

        // dealer plays cards
        dealerTurn();

        // doubles revealed
        // if player has hidden card then flip
        for (var player : this.getPlayers()) {
            for (var card : player.getHand()) {
                if (card.isFaceDown()) card.flip();
            }
        }
    }

    public void playersTurn() {
        // each player makes a turn
        for (var player : this.getPlayers()) {
            player.playTurn(this.getDealer(), this.getShoe());
        }
    }

    public void dealerTurn() {
        this.getDealer().playTurn(null, this.getShoe());
    }

    private void handleEarnings() {
        var dealerResults = this.getDealer().calculateHandValue();
        // if dealer busts reward players
        // otherwise check if players wins dealer
        if (dealerResults > 21) {
            // if dealer busts reward players
            System.out.println("Dealer busts and players get paid");
            for (var player : this.getPlayers()) {
                var bet = this.getBets().get(player.getId());
                player.acceptEarnings(bet);
                player.acceptEarnings(bet);
            }
        }
        else {
            for (var player : this.getPlayers()) {
                var playerResult = player.calculateHandValue();
                if (playerResult < dealerResults) {
                    System.out.println("Player looses");
                    var bet = this.getBets().get(player.getId());
                    this.getDealer().acceptEarnings(bet);
                } else if (playerResult > dealerResults) {
                    System.out.println("Player wins");
                    var bet = this.getBets().get(player.getId());
                    player.acceptEarnings(bet);
                    player.acceptEarnings(bet);
                } else {
                    System.out.println("Draw");
                    var bet = this.getBets().get(player.getId());
                    player.acceptEarnings(bet);
                }
            }
            // if player is less than loses money
            // if player is equal then keep money
            // if player is greater than wins money
        }
    }
}
