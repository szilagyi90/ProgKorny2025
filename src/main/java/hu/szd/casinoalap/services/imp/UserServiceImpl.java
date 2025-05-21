//package hu.szd.casinoalap.services.imp;
//
//import hu.szd.casinoalap.domain.player.User;
//import hu.szd.casinoalap.repository.UserRepository;
//import hu.szd.casinoalap.services.UserService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public void addUser(User user) { userRepository.addUser(user);
//
//    }
//
//    @Override
//    public User findUserByUsername(String username) {
//        return userRepository.findUserByName(username);
//    }
//
//    @Override
//    public User findUserByUserId(int userId) {
//        return userRepository.findUserByUserId(userId);
//    }
//
//    @Override
//    public int newUserId() {
//        return userRepository.nextUserId();
//    }
//}
