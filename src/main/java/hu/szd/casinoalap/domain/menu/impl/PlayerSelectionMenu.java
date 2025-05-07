package hu.szd.casinoalap.domain.menu.impl;

import hu.szd.casinoalap.domain.player.repositoryService.PlayerRepositoryService;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class PlayerSelectionMenu implements Menu {

    private final PlayerRepositoryService playerRepositoryService;
    private final PlayerActionMenu playerActionMenu;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public PlayerSelectionMenu(PlayerRepositoryService playerRepositoryService, @Qualifier("playerActionMenu") PlayerActionMenu playerActionMenu) {
        this.playerRepositoryService = playerRepositoryService;
        this.playerActionMenu = playerActionMenu;
    }

    @Override
    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Játékos választó menü ---");
            playerRepositoryService.listPlayers();
            System.out.println("\n1. Létező játékos kiválasztása");
            System.out.println("2. Új játékos létrehozása");
            System.out.println("0. Kilépés");
            System.out.print("Válassz egy opciót: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Add meg a játékos ID-ját: ");
                    int id = scanner.nextInt();
                    try {
                        Player selectedPlayer = playerRepositoryService.findPlayerById(id);
                        playerActionMenu.setPlayer(selectedPlayer);
                        playerActionMenu.showMenu();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hiba: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Add meg az új játékos nevét: ");
                    String newPlayerName = scanner.nextLine();
                    System.out.println("Add meg az új játékos jelszavát: ");
                    String newPlayerPassword = scanner.nextLine();
                    Player newPlayer = new Player(playerRepositoryService.newId(), newPlayerName, 0, 0, newPlayerPassword);
                    playerRepositoryService.addPlayer(newPlayer);
                }



                case 0 -> {
                    System.out.println("Kilépés...");
                    running = false;
                }
                default -> System.out.println("Érvénytelen opció!");
            }
        }
    }
    }
