package hu.szd.casinoalap.domain.player.repositoryService.imp;

import hu.szd.casinoalap.domain.player.repositoryService.PlayerRepositoryService;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerRepositoryServiceImpl implements PlayerRepositoryService {

    private final PlayerRepository playerRepository;

    public PlayerRepositoryServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepository.addPlayer(player);
    }

    @Override
    public void listPlayers() {
        List<Player> players = playerRepository.getAllPlayers();
        if (players.isEmpty()) {
            System.out.println("Nincsenek játékosok.");
        } else {
            for (Player player : players) {
                System.out.println(player);
            }
        }
    }

    @Override
    public Player findPlayerById(int id) {
        return playerRepository.findPlayerById(id);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.updatePlayer(player);
    }

    @Override
    public int newId() { return playerRepository.nextId(); }

    @Override
    public void deletePlayer(Player player) { playerRepository.deletePlayer(player); }

    @Override
    public Player findPlayerByUsername(String username) {
        return playerRepository.findPlayerByUsername(username);
    }


}
