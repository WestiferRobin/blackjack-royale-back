package com.mu.blackjackroyale.local.player;

import com.mu.blackjackroyale.local.chips.Chip;
import com.mu.blackjackroyale.local.chips.ChipBet;
import com.mu.blackjackroyale.local.drawer.Drawer;
import com.mu.blackjackroyale.local.drawer.cards.Card;

import java.util.Scanner;

public class UserPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void playTurn(Player opponent, Drawer drawer) {
        while (this.calculateHandValue() <= 21) {
            System.out.println();
            System.out.println(this.toString());
            System.out.println("Choose an option:");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            System.out.println("3. Double Down");
//            System.out.println("4. Split");
            System.out.print("Enter your choice: ");
            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception ex) {
                continue;
            }

//            if (choice >= 1 && choice <= 4) {
            if (choice >= 1 && choice <= 3) {
                Card card;
                switch (choice) {
                    case 1:
                        card = drawer.dealCard();
                        this.receiveCard(card);
                        break;
                    case 3:
                        card = drawer.dealCard();
                        card.flip();
                        this.receiveCard(card);
                        return;
                    default:
                        return;
                }
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    @Override
    public ChipBet placeBet(int minValue, int maxValue) {

        var chipBet = new ChipBet();
        System.out.println();
        System.out.println(this.getChipBank());

        boolean isFirst = true;
        while (isFirst ||
            (minValue <= chipBet.calculateBetValue() && chipBet.calculateBetValue() <= maxValue)) {
            isFirst = false;

            System.out.print("Place Bet: ");
            var answer = scanner.nextLine();
            if (answer.toLowerCase().equals("no") ) break;

            String[] betCommand;
            try {
                betCommand = answer.split(" ");
                if (betCommand.length != 2) continue;
            } catch (Exception ex) {
                continue;
            }

            var chipColor = betCommand[0];
            var chipAmount = Integer.parseInt(betCommand[1]);

            Chip chip;
            switch (chipColor.toLowerCase()) {
                case "purple":
                    chip = Chip.Purple;
                    break;
                case "black":
                    chip = Chip.Black;
                    break;
                case "green":
                    chip = Chip.Green;
                    break;
                case "blue":
                    chip = Chip.Blue;
                    break;
                case "red":
                    chip = Chip.Red;
                    break;
                case "white":
                    chip = Chip.White;
                    break;
                default:
                    continue;
            }

            if (this.getChipBank().getBank().containsKey(chip)) {
                var bankAmount = this.getChipBank().getBank().get(chip);
                if (bankAmount - chipAmount >= 0) {
                    this.getChipBank().getBank().put(chip, bankAmount - chipAmount);
                    if (chipBet.getBet().containsKey(chip)) {
                        var amount = chipBet.getBet().get(chip);
                        chipBet.getBet().put(chip, amount + chipAmount);
                    } else {
                        chipBet.getBet().put(chip, chipAmount);
                    }
                }
            }

            System.out.print("End of bet? ");
            var exitAnswer = scanner.next();
            if (exitAnswer.toLowerCase().equals("yes") ) break;
        }
        System.out.println("\nYou placed: \n" + chipBet);
        return chipBet;
    }

    @Override
    public String toString() {
        return "User: " + super.toString();
    }
}
