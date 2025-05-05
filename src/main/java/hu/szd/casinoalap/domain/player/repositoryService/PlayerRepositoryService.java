package hu.szd.casinoalap.domain.player.repositoryService;

import hu.szd.casinoalap.domain.player.Player;

public interface PlayerRepositoryService {

    void addPlayer(Player player);
    void listPlayers();
    Player findPlayerById(int id);
    void updatePlayer(Player player);
    int newId();
    void deletePlayer(Player player);
}
