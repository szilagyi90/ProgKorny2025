package hu.szd.casinoalap.repository.impl;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerRepositoryImpl implements PlayerRepository {

    private final List<Player> PLAYERS = new ArrayList<>(List.of(
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
    public void deletePlayer(Player player) {
        try {
            PLAYERS.remove(player);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int nextId() {
        int newId = PLAYERS.size() + 1;
        for (Player player : PLAYERS){
            if (newId == player.getId()){
                newId++;
            }
        }
        return newId;
    }
    }

