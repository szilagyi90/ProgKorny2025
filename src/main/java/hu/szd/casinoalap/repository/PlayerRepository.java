package hu.szd.casinoalap.repository;

import hu.szd.casinoalap.domain.player.Player;

import java.util.List;

public interface PlayerRepository {

    List<Player> getAllPlayers();

    void updatePlayer(Player player);

    void addPlayer(Player player);

    Player findPlayerById(int id);

    void deletePlayer(int id);

    int nextId();
}
