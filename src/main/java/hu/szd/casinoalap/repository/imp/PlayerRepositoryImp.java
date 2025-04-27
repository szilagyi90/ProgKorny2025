package hu.szd.casinoalap.repository.imp;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerRepositoryImp implements PlayerRepository {

    private List<Player> PLAYERS = new ArrayList<>(List.of(
            new Player(1, "Dávid", 1000, 1000)
    ));

    @Override
    public List<Player> getAllPlayers() {
        return PLAYERS;
    }

    @Override
    public void updatePlayer(Player updatedP) {
        for (int i = 0; i < PLAYERS.size(); i++) {
            if (PLAYERS.get(i).getId() == updatedP.getId()) {
                PLAYERS.set(i, updatedP);
            }
        }
    }

    @Override
    public void addPlayer(Player player) {
        PLAYERS.add(player);
    }

    @Override
    public Player findPlayerById(int id) {
        for (Player player : PLAYERS) {
            if (player.getId() == id) {
                return player;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen ID-jű játékos: " + id);
    }

    @Override
    public void deletePlayer(int id) {
        for (Player player : PLAYERS) {
            if (player.getId() == id) {
                PLAYERS.remove(player);
                System.out.println("A " + id +" ID-jú játékos törölve");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "PlayerRepositoryImp{" +
                "PLAYERS=" + PLAYERS +
                '}';
    }
}
