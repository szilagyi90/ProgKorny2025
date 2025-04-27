package hu.szd.casinoalap.domain.menu.imp;

import hu.szd.casinoalap.controller.imp.PlayerControllerImp;
import hu.szd.casinoalap.domain.games.GameService;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;

import java.util.Scanner;

public class PlayerActionMenu implements Menu {

    private final PlayerControllerImp playerController;
    private final PlayerRepository playerRepository;
    private final Player selectedPlayer;
    private final Scanner scanner = new Scanner(System.in);

    public PlayerActionMenu(PlayerControllerImp playerController, PlayerRepository playerRepository, Player selectedPlayer) {
        this.playerController = playerController;
        this.playerRepository = playerRepository;
        this.selectedPlayer = selectedPlayer;
    }

    @Override
    public void showMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Játékos műveletek menü ---");
            System.out.println("Aktuális játékos: " + selectedPlayer.getUsername() + " (Zsetonok: " + selectedPlayer.getCurrentChips() + ")");
            System.out.println("1. Játék választása");
            //System.out.println("2. Játékos törlése");
            System.out.println("3. Vissza a játékos választó menübe");
            System.out.print("Válassz egy opciót: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> new GameService(selectedPlayer).chooseGame(); //game.play();
//                case 2 -> {
//                    playerController.deletePlayer(selectedPlayer.getId());
//                    running = false;
//                }
                case 3 -> running = false;
                default -> System.out.println("Érvénytelen opció!");
            }
        }
    }
    }
