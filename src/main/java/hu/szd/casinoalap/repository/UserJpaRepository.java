package hu.szd.casinoalap.repository;

import hu.szd.casinoalap.domain.player.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
