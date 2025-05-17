package hu.szd.casinoalap.repository;

import hu.szd.casinoalap.domain.games.Game;

import java.util.List;

public interface GameRepository {
    List<Game> getAllGames();
    Game findGameByName(String name);
}
