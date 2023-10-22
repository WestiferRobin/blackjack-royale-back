package com.mu.blackjackroyale.local.drawer.cards;

import com.mu.blackjackroyale.local.drawer.cards.Card;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @Test
    public void testCardConstructorWithRawValue() {
        Card card = new Card("A", "Hearts", 11);
        assertEquals("A", card.getValue());
        assertEquals("Hearts", card.getSuit());
        assertEquals(11, card.getRawValue());
    }

    @Test
    public void testCardConstructorWithoutRawValue() {
        Card card = new Card("K", "Spades");
        assertEquals("K", card.getValue());
        assertEquals("Spades", card.getSuit());
        assertEquals(10, card.getRawValue()); // King should have a raw value of 10
    }

    @Test
    public void testToString() {
        Card card = new Card("2", "Diamonds");
        assertEquals("2:Diamonds", card.toString());
    }

    @Test
    public void testGetRawValueForAce() {
        Card card = new Card("A", "Clubs");
        assertEquals(11, card.getRawValue()); // Ace should have a raw value of 11
    }

    @Test
    public void testGetRawValueForNumberCard() {
        Card card = new Card("7", "Hearts");
        assertEquals(7, card.getRawValue());
    }

    // Add more test cases as needed

    @Test
    public void testInvalidCardValue() {
        // Test for an invalid card value
        assertThrows(IllegalArgumentException.class, () -> new Card("X", "Spades"));
    }

    @Test
    public void testInvalidCardSuit() {
        // Test for an invalid card suit
        assertThrows(IllegalArgumentException.class, () -> new Card("K", "Stars"));
    }
}

