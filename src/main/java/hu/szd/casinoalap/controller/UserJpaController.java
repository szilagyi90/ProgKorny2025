package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.domain.player.User;
import hu.szd.casinoalap.services.imp.PlayerJpaService;
import hu.szd.casinoalap.services.imp.UserJpaService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserJpaController {
    private final UserJpaService userJpaService;
    private final PlayerJpaService playerJpaService;

    public UserJpaController(UserJpaService userJpaService, PlayerJpaService playerJpaService) {
        this.userJpaService = userJpaService;
        this.playerJpaService = playerJpaService;
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "users/login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpSession session) {
        User existingUser = userJpaService.getByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("loggedUser", user);
            return "users/profile";
        } else {
            return "users/login?error";
        }
    }
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "users/register";
    }
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userJpaService.save(user);
        return "redirect:/users/login";
    }
    @GetMapping("/profile")
    public String showProfile(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedUser");

        List<Player> players = playerJpaService.getPlayersByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("players", players);

        return "users/profile";
    }


}
