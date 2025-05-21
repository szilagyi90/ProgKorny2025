//package hu.szd.casinoalap.repository.impl;
//
//import hu.szd.casinoalap.domain.player.User;
//import hu.szd.casinoalap.repository.UserRepository;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class UserRepositoryImpl implements UserRepository {
//
//    private final List<User> users;
//
//    public UserRepositoryImpl() {
//        users = new ArrayList<>();
//        users.add(new User("user1", "asd", 1));
//    }
//
//    @Override
//    public List<User> getAllUser() {
//        return users;
//    }
//
//    @Override
//    public User findUserByName(String userName) {
//        for(User user : users){
//            if(user.getUsername().equals(userName)){return user;}
//        }
//        return null;
//    }
//
//    @Override
//    public void addUser(User user) {
//        users.add(user);
//    }
//
//    @Override
//    public int nextUserId() {
//        int newUserId = users.size() + 1;
//        for(User user : users){
//            if(newUserId == user.getUserId()){
//                newUserId++;
//            }
//        }
//        return newUserId;
//    }
//
//    @Override
//    public User findUserByUserId(int userId) {
//        for(User user : users){
//            if(user.getUserId() == userId){
//                return user;
//            }
//        }
//        return null;
//    }
//}
