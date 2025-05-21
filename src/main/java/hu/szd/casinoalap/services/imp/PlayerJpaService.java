package hu.szd.casinoalap.services.imp;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.domain.player.User;
import hu.szd.casinoalap.repository.PlayerJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayerJpaService {
    private final PlayerJpaRepository playerRepo;

    public PlayerJpaService(PlayerJpaRepository playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<Player> getPlayersByUser(User user) {
        return playerRepo.findByUser(user);
    }

    public void addPlayer(Player player) {
        playerRepo.save(player);
    }
    public void generateChips(Player player, int amount) {
        player.setCurrentChips(player.getCurrentChips() + amount);
        player.setTotalGeneratedChips(player.getTotalGeneratedChips() + amount);
        playerRepo.save(player);
    }
    public void delete(Player player) {
        playerRepo.delete(player);
    }
}
