package hu.szd.casinoalap.services.imp;


import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.domain.modul.BetValidator;
import hu.szd.casinoalap.domain.player.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl {

    private final List<Game> games;
    private final BetValidator betValidator;
    private final PlayerJpaService playerService;

    public GameServiceImpl(List<Game> games, BetValidator betValidator, PlayerJpaService playerService) {
        this.games = games;
        this.betValidator = betValidator;
        this.playerService = playerService;
    }

    public Game findGameByName(String name) {
        for (Game game : games) {
            if (game.name().equals(name)) {
                return game;
            }
        }
        return null;
    }

    public int play(String gameName, Player player, int bet) {
        Game game = findGameByName(gameName);

        if (!betValidator.isValidBet(player, bet, game.minimumBet())) {
            throw new IllegalArgumentException(
                    "Érvénytelen tét: " + "minBet= " + game.minimumBet() + ", maxBet= " + player.getCurrentChips());
        }

        double multiplier = game.play();
        int delta = (int)(bet * multiplier);

        player.setCurrentChips(player.getCurrentChips() + delta);

        playerService.addPlayer(player);

        return delta;
    }
}