package hu.szd.casinoalap.repository.impl;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerRepositoryImpl implements PlayerRepository {

    private final List<Player> players;

    public PlayerRepositoryImpl() {
        players = new ArrayList<>();
        players.add(new Player(1, "user1", 1000, 1000, "asd"));
        players.add(new Player(2, "user2", 2000, 2000, "asd"));
    }

    @Override
    public List<Player> getAllPlayers() {
        return players;
    }

    @Override
    public void updatePlayer(Player updatedP) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getId() == updatedP.getId()) {
                players.set(i, updatedP);
            }
        }
    }

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public Player findPlayerById(int id) {
        for (Player player : players) {
            if (player.getId() == id) {
                return player;
            }
        }
        throw new IllegalArgumentException("Nincs ilyen ID-jű játékos: " + id);
    }

    @Override
    public void deletePlayer(Player player) {
        try {
            players.remove(player);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int nextId() {
        int newId = players.size() + 1;
        for (Player player : players){
            if (newId == player.getId()){
                newId++;
            }
        }
        return newId;
    }

    @Override
    public Player findPlayerByUsername(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) { return player; }
        }
        return null;
    }
}

