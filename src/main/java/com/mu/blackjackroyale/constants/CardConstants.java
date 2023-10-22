package com.mu.blackjackroyale.constants;

import java.util.Arrays;
import java.util.List;

public class CardConstants {
    public static List<String> CardValues = Arrays.asList(
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "J",
            "Q",
            "K",
            "A"
    );

    public static int getRawValue(String value) {
        switch (value) {
            case "A":
                return 11;
            case "J":
            case "Q":
            case "K":
                return 10;
            default:
                return Integer.parseInt(value);
        }
    }

    public static List<String> CardSuits = Arrays.asList(
            "S",
            "H",
            "D",
            "C"
    );
}
