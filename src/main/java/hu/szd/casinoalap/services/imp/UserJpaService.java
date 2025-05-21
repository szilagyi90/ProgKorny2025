package hu.szd.casinoalap.services.imp;

import hu.szd.casinoalap.domain.player.User;
import hu.szd.casinoalap.repository.UserJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserJpaService {
    private final UserJpaRepository userRepo;

    public UserJpaService(UserJpaRepository userRepo) {
        this.userRepo = userRepo;
    }
    public User getByUsername(String username) {
        return userRepo.findByUsername(username);
    }
    public void save(User user) {
        userRepo.save(user);
    }
}
