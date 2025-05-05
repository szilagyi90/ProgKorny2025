package hu.szd.casinoalap.domain.games.impl;

import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.domain.service.BetValidator;
import hu.szd.casinoalap.domain.player.Player;

import java.util.Random;
import java.util.Scanner;

public class DoubleOrNothingGame implements Game {

    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    private final Player player;
    private final BetValidator betValidator = new BetValidator();


    public DoubleOrNothingGame(Player player) {
        this.player = player;
    }

    @Override
    public int minimumBet() {
        return 10;
    }

    @Override
    public void play() {
        System.out.println("\nDupla vagy Semmi játék indult!");
        System.out.print("Add meg a téted: ");
        int bet = scanner.nextInt();
        scanner.nextLine();

        if (!betValidator.isValidBet(player, bet, minimumBet())) {
            System.out.println("Érvénytelen tét!");
            return;
        }

        boolean win = random.nextBoolean();
        if (win) {
            System.out.println("Gratulálok! Dupláztad a téted!");
        } else {
            bet = bet*(-1);
            System.out.println("Sajnálom, elveszítetted a tétet!");
        }
    player.setCurrentChips(player.getCurrentChips()+bet);
    }



}

