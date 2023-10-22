package com.mu.blackjackroyale.local.drawer;

import com.mu.blackjackroyale.local.drawer.cards.Card;

import java.util.List;

public interface Drawer {
    int size();
    void shuffle();
    void reload();
    boolean isEmpty();
    List<Card> dealAllCards();
    List<Card> dealCards(int times);
    Card dealCard();
}
