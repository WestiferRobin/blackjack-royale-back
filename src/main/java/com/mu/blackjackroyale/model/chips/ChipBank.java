package com.mu.blackjackroyale.model.chips;

import com.mu.blackjackroyale.enums.Chip;
import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "chip_banks")
public class ChipBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private UUID Id;
    public UUID getId() { return this.Id; }

    @ElementCollection
    @CollectionTable(name = "chip_bank_items", joinColumns = @JoinColumn(name = "chip_bank_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "chip")
    private Map<Chip, Integer> bank = new HashMap<>();
    public Map<Chip, Integer> getBank() { return this.bank; }

    public ChipBank() {
        this.bank.put(Chip.White, 25);
        this.bank.put(Chip.Red, 25);
        this.bank.put(Chip.Blue, 10);
        this.bank.put(Chip.Green, 10);
        this.bank.put(Chip.Black, 5);
        this.bank.put(Chip.Purple, 1);
    }

    public int getTotal() {
        int total = 0;
        for (Chip chip : this.bank.keySet()) {
            var value = chip.getValue();
            var amount = this.bank.get(chip);
            total += (amount * value);
        }
        return total;
    }

    public int getChipCount() {
        int count = 0;
        for (var chip : this.bank.keySet()) {
            count += this.bank.get(chip);
        }
        return count;
    }

    public void addChips(ChipBet bet) {
        for (var chip : bet.getBet().keySet()) {
            var betAmount = bet.getBet().get(chip);
            if (this.bank.containsKey(chip)) {
                var amount = this.bank.get(chip);
                this.bank.put(chip, amount + betAmount);
            } else {
                this.bank.put(chip, betAmount);
            }
        }
    }

    @Override
    public String toString() {
        var result = "ChipBank:\n";
        for (var chip : this.bank.keySet()) {
            var line = chip.name() + ":$" + chip.getValue();
            line += " => " + this.bank.get(chip) + "\n";
            result += line;
        }
        result += "Total: $" + getTotal();
        result += " #" + getChipCount();
        return result;
    }
}
