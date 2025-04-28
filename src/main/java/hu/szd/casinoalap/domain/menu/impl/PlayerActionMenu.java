package hu.szd.casinoalap.domain.menu.impl;

import hu.szd.casinoalap.controller.RepositoryController;
import hu.szd.casinoalap.controller.imp.RepositoryControllerImpl;
import hu.szd.casinoalap.domain.games.GameService;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.domain.service.ChipGenerator;
import hu.szd.casinoalap.repository.PlayerRepository;
import hu.szd.casinoalap.repository.impl.PlayerRepositoryImpl;

import java.util.Scanner;

public class PlayerActionMenu implements Menu {

    private final Player selectedPlayer;
    private final Scanner scanner = new Scanner(System.in);
    private final RepositoryController repositoryController; //= new RepositoryControllerImpl(new PlayerRepositoryImpl());

    public PlayerActionMenu(Player selectedPlayer, RepositoryController repositoryController) {
        this.selectedPlayer = selectedPlayer;
        this.repositoryController = repositoryController;
    }

    @Override
    public void showMenu() {
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
                case 1 -> new GameService(selectedPlayer).chooseGame(); //game.play();
                case 2 -> {
                    System.out.println("Adja meg a kívánt mennyiséget: ");
                    int amount = scanner.nextInt();
                    new ChipGenerator().generateChip(selectedPlayer, amount);
                }

                case 3 -> {
                    repositoryController.deletePlayerById(selectedPlayer.getId());
                    running = false;
                }
                case 0 -> running = false;

                default -> System.out.println("Érvénytelen opció!");
            }
        }
    }
    }
