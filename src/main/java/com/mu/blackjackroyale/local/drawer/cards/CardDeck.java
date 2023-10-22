package com.mu.blackjackroyale.local.drawer.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardDeck {
    public static List<Card> createDeck(boolean isShuffled) {
        var cards = new ArrayList<Card>();
        for (var suit : CardConstants.CardSuits) {
            for (var value : CardConstants.CardValues) {
                var card = new Card(value, suit);
                cards.add(card);
            }
        }
        if (isShuffled) {
            Collections.shuffle(cards);
        }
        return cards;
    }
}
