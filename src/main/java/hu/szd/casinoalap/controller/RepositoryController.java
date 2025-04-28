package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;

public interface RepositoryController {

    void addPlayer(Player player);
    void listPlayers();
    Player findPlayerById(int id);
    void updatePlayer(Player player);
    int newId();
    void deletePlayer(Player player);
}
