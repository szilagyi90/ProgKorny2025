package hu.szd.casinoalap.domain.menu.impl;

import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.domain.games.impl.DoubleOrNothingGame;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameSelectionMenu implements Menu {
    private final Map<Integer, Game> games = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private Player player;

    public GameSelectionMenu(Player player){
        games.put(1, new DoubleOrNothingGame(player));
    }

    @Override
    public void showMenu() {
        System.out.println("\n--- Játék választó ---");
        System.out.println("1. Dupla vagy Semmi");

        System.out.print("Válassz egy játékot: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        Game selectedGame = games.get(choice);

        if (selectedGame != null){
            selectedGame.play();
        }else{
            System.out.println("Érvénytelen választás!");
        }
    }
    }
