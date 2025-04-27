package hu.szd.casinoalap.domain.games.imp;

import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.domain.games.betvalidator.BetValidator;
import hu.szd.casinoalap.domain.player.Player;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothingGame implements Game {

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final int minimumBet = 10;
    private Player player;
    private BetValidator betValidator = new BetValidator();

    public DoubleOrNothingGame(Player player) {
        this.player = player;
    }

    @Override
    public void play() {
        System.out.println("\nDupla vagy Semmi játék indult!");
        System.out.print("Add meg a téted: ");
        int bet = scanner.nextInt();
        scanner.nextLine();

        if (!betValidator.isValidBet(player, bet, minimumBet)) {
            System.out.println("Érvénytelen tét!");
            return;
        }

        boolean win = random.nextBoolean();
        if (win) {
            bet = bet*2;
            System.out.println("Gratulálok! Dupláztad a téted!");
        } else {
            bet = bet*(-1);
            System.out.println("Sajnálom, elveszítetted a tétet!");
        }
    player.setCurrentChips(player.getCurrentChips()+bet);
    }

}

