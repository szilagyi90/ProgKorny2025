package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import hu.szd.casinoalap.services.PlayerService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;

@Controller
@RequestMapping("/players")
@SessionAttributes("player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "players/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Player player = playerService.findPlayerByUsername(username);
        if (player != null && player.getPassword().equals(password)) {
            model.addAttribute("username", player.getUsername());
            model.addAttribute("currentChips", player.getCurrentChips());
            model.addAttribute("totalGeneratedChips", player.getTotalGeneratedChips());
            model.addAttribute("player", player);
            return "players/profile";
        } else {
            return "players/login?error";
        }
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "players/register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        if (playerService.findPlayerByUsername(username) != null) {
            return "players/register?error";
        }
        Player newPlayer = new Player(playerService.newId(), username,0, 0, password);
        playerService.addPlayer(newPlayer);
        return "players/login";
    }

    @GetMapping("/profile")
    public String showHome(@SessionAttribute("player") Player player,
                           Model model) {
        model.addAttribute("username", player.getUsername());
        model.addAttribute("currentChips", player.getCurrentChips());
        model.addAttribute("totalGeneratedChips", player.getTotalGeneratedChips());
        return "players/profile";
    }

    @GetMapping("/generate-chips")
    public String showGenerateChipsForm(@SessionAttribute("player") Player player, Model model) {
        model.addAttribute("username", player.getUsername());
        return "players/chipGenerator";
    }

    @PostMapping("/generate-chips")
    public String generateChips(@SessionAttribute("player") Player player,
                                @RequestParam int amount) {
        player.setCurrentChips(player.getCurrentChips() + amount);
        player.setTotalGeneratedChips(player.getTotalGeneratedChips() + amount);
        playerService.updatePlayer(player);
        return "players/profile";
    }

    @GetMapping("/delete-player")
    public String deletePlayer(@SessionAttribute("player") Player player,
                               SessionStatus status) {
        playerService.deletePlayer(player);
        status.setComplete();
        return "players/login";
    }
}
