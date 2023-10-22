package com.mu.blackjackroyale.local.chips;

import java.util.Hashtable;
import java.util.Map;

public class ChipBet {
    private Map<Chip, Integer> bet;
    public Map<Chip, Integer> getBet() { return this.bet; }

    public ChipBet(Map<Chip, Integer> bet) {
        this.bet = bet;
    }

    public ChipBet() {
        this.bet = new Hashtable<>();
    }

    public int calculateBetValue() {
        var result = 0;
        for (var chip : bet.keySet()) {
            int value = chip.getValue();
            int amount = bet.get(chip);
            result += (value * amount);
        }
        return result;
    }

    @Override
    public String toString() {
        var result = "";
        for (var chip : this.bet.keySet()) {
            var line = chip.name() + ":$" + chip.getValue();
            line += " => " + this.bet.get(chip) + "\n";
            result += line;
        }
        result += "Total: $" + calculateBetValue();
        return result;
    }
}
