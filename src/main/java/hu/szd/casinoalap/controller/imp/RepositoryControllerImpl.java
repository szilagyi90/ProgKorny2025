package hu.szd.casinoalap.controller.imp;

import hu.szd.casinoalap.controller.RepositoryController;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import hu.szd.casinoalap.repository.impl.PlayerRepositoryImpl;

import java.util.List;

public class RepositoryControllerImpl implements RepositoryController {

    private final PlayerRepository playerRepository = new PlayerRepositoryImpl();

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
                System.out.println(player);
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

    @Override
    public int newId() { return playerRepository.nextId(); }

    @Override
    public void deletePlayer(Player player) { playerRepository.deletePlayer(player); }


}
