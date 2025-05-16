package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
@SessionAttributes("player")
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
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
        Player player = playerRepository.findPlayerByUsername(username);
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
    public String register(@RequestParam String username, @RequestParam String password, Model model) {
        if (playerRepository.findPlayerByUsername(username) != null) {
            return "players/register?error";
        }
        Player newPlayer = new Player(playerRepository.nextId(), username,0, 0, password);
        playerRepository.addPlayer(newPlayer);
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
        //egy mentést bele lehetne rakni: updatePlayer();
        return "players/profile";
    }
}
