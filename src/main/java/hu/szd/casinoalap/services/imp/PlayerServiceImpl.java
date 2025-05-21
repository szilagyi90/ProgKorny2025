//package hu.szd.casinoalap.services.imp;
//
//import hu.szd.casinoalap.domain.player.User;
//import hu.szd.casinoalap.services.PlayerService;
//import hu.szd.casinoalap.domain.player.Player;
//import hu.szd.casinoalap.repository.PlayerRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@Service
//public class PlayerServiceImpl implements PlayerService {
//
//    private final PlayerRepository playerRepository;
//
//    public PlayerServiceImpl(PlayerRepository playerRepository) {
//
//        this.playerRepository = playerRepository;
//    }
//
//    @Override
//    public void addPlayer(Player player) {
//        playerRepository.addPlayer(player);
//    }
//
//    @Override
//    public List listPlayersByUser(User user) {
//        List<Player> players = playerRepository.getPlayersByUser(user);
//        return players;
//    }
//
//    @Override
//    public Player findPlayerById(int id) {
//        return playerRepository.findPlayerById(id);
//    }
//
//    @Override
//    public void updatePlayer(Player player) {
//        playerRepository.updatePlayer(player);
//    }
//
//    @Override
//    public int newId() { return playerRepository.nextId(); }
//
//    @Override
//    public void deletePlayer(Player player) { playerRepository.deletePlayer(player); }
//
//    @Override
//    public Player findPlayerByUsername(String username) {
//        return playerRepository.findPlayerByPlayerName(username);
//    }
//
//
//}
