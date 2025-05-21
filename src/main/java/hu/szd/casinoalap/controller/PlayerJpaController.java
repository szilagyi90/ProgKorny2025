package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.services.imp.PlayerJpaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/players")
@SessionAttributes("player")
public class PlayerJpaController {
    private final PlayerJpaService playerJpaService;

    public PlayerJpaController(PlayerJpaService playerJpaService) {
        this.playerJpaService = playerJpaService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/player")
    public String showHome(@SessionAttribute("player") Player player,
                           Model model) {
        model.addAttribute("username", player.getPlayerName());
        model.addAttribute("currentChips", player.getCurrentChips());
        model.addAttribute("totalGeneratedChips", player.getTotalGeneratedChips());
        return "players/player";
    }
    @GetMapping("/generate-chips")
    public String showGenerateChipsForm(@SessionAttribute("player") Player player, Model model) {
        model.addAttribute("username", player.getPlayerName());
        return "players/chipGenerator";
    }

    @GetMapping("/delete-player")
    public String deletePlayer(@SessionAttribute("player") Player player,
                               SessionStatus status) {
        playerJpaService.delete(player);
        status.setComplete();
        return "players/login";
    }
}
