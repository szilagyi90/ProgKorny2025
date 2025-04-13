package hu.szd.progkornyCasino.service;

import hu.szd.progkornyCasino.model.Player;
import hu.szd.progkornyCasino.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {

    private final PlayerRepository playerRepository;
    private final Random random = new Random();

    public GameService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player playGame(Long playerId, int bet){
        Player player = playerRepository.findById(playerId).orElseThrow();

        boolean won = random.nextBoolean();
        if(won){
            player.setChips(player.getChips() + bet * 2);
        }else{
            player.setChips(player.getChips() - bet);
        }
        return playerRepository.save(player);
    }

    public Player generateChips(Long playerId, int amount){
        Player player = playerRepository.findById(playerId).orElseThrow();
        player.setChips(player.getChips() + amount);
        player.setTotalGenerated(player.getTotalGenerated() + amount);
        return playerRepository.save(player);
    }
}
