package hu.szd.casinoalap.repository.impl;

import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.repository.GameRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class GameRepositoryImpl implements GameRepository {
    private final List<Game> games;

    public GameRepositoryImpl(Collection<Game> gameBeans) {
        this.games = new ArrayList<>(gameBeans);
    }

    @Override
    public List<Game> getAllGames() { return games; }


    @Override
    public Game findGameByName(String name) {
        for(Game game : games){
            if(game.name().equals(name)){return game;}
        }
        return null;
    }

}
