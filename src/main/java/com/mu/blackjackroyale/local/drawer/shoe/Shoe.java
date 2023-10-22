package com.mu.blackjackroyale.local.drawer.shoe;

import com.mu.blackjackroyale.local.drawer.cards.Card;
import com.mu.blackjackroyale.local.drawer.cards.CardDeck;
import com.mu.blackjackroyale.local.drawer.Drawer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Shoe implements Drawer {
    private Stack<Card> cards = new Stack<>();

    private boolean isShuffled;
    private int deckSize;
    public Shoe(int deckSize) {
        this.isShuffled = true;
        this.deckSize = deckSize;
        initDeck();
    }

    public Shoe(int deckSize, boolean isShuffled) {
        this.isShuffled = isShuffled;
        this.deckSize = deckSize;
        initDeck();
    }

    public void initDeck() {
        var decksOfCards = new ArrayList<Card>();
        int count = 0;
        while (count < deckSize) {
            var cardDeck = CardDeck.createDeck(this.isShuffled);
            for (var card : cardDeck) {
                decksOfCards.add(card);
            }
            count++;
        }
        if (this.isShuffled) Collections.shuffle(decksOfCards);
        for (var card : decksOfCards) {
            this.cards.push(card);
        }
    }

    @Override
    public int size() {
        return this.cards.size();
    }

    @Override
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    @Override
    public void reload() {
        initDeck();
    }

    @Override
    public boolean isEmpty() {
        return this.cards.isEmpty();
    }

    @Override
    public List<Card> dealAllCards() {
        var allCards = new ArrayList<Card>();
        while (!this.isEmpty()) {
            var card = dealCard();
            allCards.add(card);
        }
        return allCards;
    }

    @Override
    public List<Card> dealCards(int times) {
        int count = 0;
        var rangeCards = new ArrayList<Card>();
        while (count < times) {
            var card = dealCard();
            rangeCards.add(card);
            count++;
        }
        return rangeCards;
    }

    @Override
    public Card dealCard() {
        return this.cards.pop();
    }
}
