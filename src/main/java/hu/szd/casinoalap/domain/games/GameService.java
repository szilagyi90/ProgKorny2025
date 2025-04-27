package hu.szd.casinoalap.domain.games;

import hu.szd.casinoalap.domain.games.imp.DoubleOrNothingGame;
import hu.szd.casinoalap.domain.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameService {
    private final Map<Integer, Game> games = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);
    private Player player;

    public GameService(Player player){
        games.put(1, new DoubleOrNothingGame(player));
    }

    public void chooseGame(){
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
