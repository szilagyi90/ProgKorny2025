package hu.szd.casinoalap.controller.imp;

import hu.szd.casinoalap.controller.PlayerController;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;

import java.util.List;

public class PlayerControllerImp implements PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerControllerImp(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    @Override
    public void addPlayer(Player player) {
        playerRepository.addPlayer(player);

    }

    @Override
    public void listPlayers() {
        List<Player> players = playerRepository.getAllPlayers();
        if (players.isEmpty()) {
            System.out.println("Nincsenek játékosok.");
        } else {
            for (Player player : players) {
                System.out.println(player); // automatikusan a toString() hívódik meg
            }
        }
    }

    @Override
    public Player findPlayerById(int id) {
        return playerRepository.findPlayerById(id);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.updatePlayer(player);
    }
}
