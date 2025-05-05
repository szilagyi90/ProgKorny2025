package hu.szd.casinoalap.domain.menu.impl;

import hu.szd.casinoalap.domain.player.repositoryService.PlayerRepositoryService;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.domain.service.ChipGenerator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
@Qualifier("playerActionMenu")
public class PlayerActionMenu implements Menu {

    private Player selectedPlayer;
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerRepositoryService playerRepositoryService; //= new RepositoryControllerImpl(new PlayerRepositoryImpl());

    public PlayerActionMenu(PlayerRepositoryService playerRepositoryService) {
        this.playerRepositoryService = playerRepositoryService;
    }
    public void setPlayer(Player player) {
        this.selectedPlayer = player;
    }
        @Override
        public void showMenu () {
            boolean running = true;

            while (running) {
                System.out.println("\n--- Játékos műveletek menü ---");
                System.out.println("Aktuális játékos: " + selectedPlayer);
                System.out.println("1. Játék választása");
                System.out.println("2. Zseton vásárlása");
                System.out.println("3. Játékos törlése");
                System.out.println("0. Vissza a játékos választó menübe");
                System.out.print("Válassz egy opciót: ");

                int option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {
                    case 1 -> new GameSelectionMenu(selectedPlayer).showMenu(); //game.play();
                    case 2 -> {
                        System.out.println("Adja meg a kívánt mennyiséget: ");
                        int amount = scanner.nextInt();
                        new ChipGenerator().generateChip(selectedPlayer, amount);
                    }

                    case 3 -> {
                        playerRepositoryService.deletePlayer(selectedPlayer);
                        System.out.println("A játékos törölve.");
                        running = false;
                    }
                    case 0 -> running = false;

                    default -> System.out.println("Érvénytelen opció!");
                }
            }
        }
    }

