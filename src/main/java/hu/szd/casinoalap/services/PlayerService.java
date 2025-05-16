package hu.szd.casinoalap.services;

import hu.szd.casinoalap.domain.player.Player;

public interface PlayerService {

    void addPlayer(Player player);
    void listPlayers();
    Player findPlayerById(int id);
    void updatePlayer(Player player);
    int newId();
    void deletePlayer(Player player);
    Player findPlayerByUsername(String username);
}
