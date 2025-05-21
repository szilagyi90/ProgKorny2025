package hu.szd.casinoalap.repository;

import hu.szd.casinoalap.domain.games.Game;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

public interface GameRepository //extends JpaRepository<Game, Id>
{
    List<Game> getAllGames();
    Game findGameByName(String name);
}
