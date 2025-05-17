package hu.szd.casinoalap.services.imp;

import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.domain.modul.BetValidator;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.GameRepository;
import hu.szd.casinoalap.repository.impl.GameRepositoryImpl;
import hu.szd.casinoalap.services.GameService;
import hu.szd.casinoalap.services.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final PlayerService playerService;
    private final BetValidator betValidator;

    public GameServiceImpl(GameRepository gameRepository, PlayerService playerService, BetValidator betValidator) {
        this.gameRepository = gameRepository;
        this.playerService = playerService;
        this.betValidator = betValidator;
    }

    public List<String> getGameNames() {
        return List.copyOf(gameRepository.getAllGames().stream()
                .map(Game::name)
                .toList());
    }

    public int getMinimumBet(String gameName) {
        Game game = gameRepository.findGameByName(gameName);
        return game.minimumBet();
    }


    public int play(String gameName, Player player, int bet) {
        Game game = gameRepository.findGameByName(gameName);
        int minBet = game.minimumBet();

        if (!betValidator.isValidBet(player, bet, minBet)) {
            throw new IllegalArgumentException(
                    "A tét és a chip-állás nem egyezik a szabályokkal: " +
                            "minBet=" + minBet + ", currentChips=" + player.getCurrentChips()
            );
        }

        double multiplier = game.play();
        int delta = (int)(bet * multiplier);

        player.setCurrentChips(player.getCurrentChips() + delta);

        playerService.updatePlayer(player);

        return delta;
    }
}
