package hu.szd.casinoalap.repository;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.domain.player.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PlayerJpaRepository extends JpaRepository<Player, Integer> {
    List<Player> findByUser(User user);
    List<Player> findByUserId(int userId);
}
