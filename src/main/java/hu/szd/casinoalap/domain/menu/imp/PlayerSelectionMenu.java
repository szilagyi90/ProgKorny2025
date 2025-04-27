package hu.szd.casinoalap.domain.menu.imp;

import hu.szd.casinoalap.controller.imp.PlayerControllerImp;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;

import java.util.Scanner;

public class PlayerSelectionMenu implements Menu {

    private final PlayerControllerImp playerController;
    private final PlayerRepository playerRepository;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerSelectionMenu(PlayerControllerImp playerController, PlayerRepository playerRepository) {
        this.playerController = playerController;
        this.playerRepository = playerRepository;
    }

    @Override
    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Játékos választó menü ---");
            playerController.listPlayers();
            System.out.println("\n1. Létező játékos kiválasztása");
            System.out.println("2. Új játékos létrehozása");
            System.out.println("3. Kilépés");
            System.out.print("Válassz egy opciót: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Add meg a játékos ID-ját: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        Player selectedPlayer = playerRepository.findPlayerById(id);
                        new PlayerActionMenu(playerController, playerRepository, selectedPlayer).showMenu();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Hiba: " + e.getMessage());
                    }
                }
                case 2 -> System.out.println("HozzáadásTeszt");//playerController.addPlayer();
                case 3 -> {
                    System.out.println("Kilépés...");
                    running = false;
                }
                default -> System.out.println("Érvénytelen opció!");
            }
        }
    }
    }
