//package hu.szd.casinoalap.controller;
//
//import hu.szd.casinoalap.domain.player.Player;
//import hu.szd.casinoalap.domain.player.User;
//import hu.szd.casinoalap.services.PlayerService;
//import hu.szd.casinoalap.services.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/users")
//@SessionAttributes("user")
//public class UserController {
//    private final UserService userService;
//    private final PlayerService playerService;
//
//    public UserController(UserService userService, PlayerService playerService) {
//        this.userService = userService;
//        this.playerService = playerService;
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "users/login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password){ //Model model) {
//        User user = userService.findUserByUsername(username);
//        if (user != null && user.getPassword().equals(password)) {
////            model.addAttribute("username", user.getUserName());
////            model.addAttribute("user", user);
//            return "users/profile";
//        } else {
//            return "users/login?error";
//        }
//    }
//
//    @GetMapping("/register")
//    public String showRegisterForm() {
//        return "users/register";
//    }
//
//    @PostMapping("/register")
//    public String register(@RequestParam String username,@RequestParam String password) {
//        if (userService.findUserByUsername(username) != null) {
//            return "users/register?error";
//        }
//        User newUser = new User(username, password, userService.newUserId());
//        userService.addUser(newUser);
//        return "users/login";
//    }
//
//    @GetMapping("/profile")
//    public String getPlayers(@SessionAttribute("user")User user, Model model){
//        List<Player> PLAYERS = playerService.listPlayersByUser(user);
//        model.addAttribute("players", PLAYERS);
//        return "login";
//    }
//
//
//}
