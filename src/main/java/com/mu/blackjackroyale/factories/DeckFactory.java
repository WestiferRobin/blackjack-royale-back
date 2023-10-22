package com.mu.blackjackroyale.factories;

import com.mu.blackjackroyale.constants.CardConstants;
import com.mu.blackjackroyale.model.cards.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckFactory {
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
