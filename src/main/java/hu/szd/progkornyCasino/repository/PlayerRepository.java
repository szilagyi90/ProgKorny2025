package hu.szd.progkornyCasino.repository;

import hu.szd.progkornyCasino.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
