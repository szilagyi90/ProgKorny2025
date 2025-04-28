package hu.szd.casinoalap.domain.menu.impl;

import hu.szd.casinoalap.controller.RepositoryController;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;

import java.util.Scanner;

public class PlayerSelectionMenu implements Menu {

    private final RepositoryController repositoryController;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerSelectionMenu(RepositoryController repositoryController) {
        this.repositoryController = repositoryController;
    }

    @Override
    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Játékos választó menü ---");
            repositoryController.listPlayers();
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
                        Player selectedPlayer = repositoryController.findPlayerById(id);
                        new PlayerActionMenu(selectedPlayer, repositoryController).showMenu();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hiba: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.println("Add meg az új játékos nevét: ");
                    String newPlayerName = scanner.nextLine();
                    Player newPlayer = new Player (repositoryController.newId(), newPlayerName, 0, 0);
                    repositoryController.addPlayer(newPlayer);
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
