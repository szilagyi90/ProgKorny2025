package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.domain.player.User;
import hu.szd.casinoalap.services.imp.PlayerJpaService;
import jakarta.servlet.http.HttpSession;
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
    @GetMapping("/create")
    public String showPlayerCreationForm(Model model) {
        model.addAttribute("player", new Player());
        return "players/create";
    }
    @PostMapping("/create")
    public String createPlayer(@ModelAttribute("player") Player player, HttpSession session) {
        User user = (User) session.getAttribute("loggedUser");

        player.setUser(user);
        player.setTotalGeneratedChips(player.getCurrentChips());
        playerJpaService.addPlayer(player);

        return "redirect:/users/profile";
    }
    @GetMapping("/playermenu")
    public String showPlayerMenu(HttpSession session, Model model) {
        Player selectedPlayer = (Player) session.getAttribute("selectedPlayer");
        model.addAttribute("player", selectedPlayer);
        return "players/playermenu";
    }
    @PostMapping("/playermenu")
    public String selectPlayer(@RequestParam("playerId") int id, HttpSession session) {
        Player selectedPlayer = playerJpaService.getPlayerById(id);

        session.setAttribute("selectedPlayer", selectedPlayer);
        return "redirect:/players/playermenu";
    }
    @PostMapping("/generate-chips")
    public String generateChips(@RequestParam("amount") int amount, HttpSession session) {
        Player player = (Player) session.getAttribute("selectedPlayer");
        playerJpaService.generateChips(player, amount);
        playerJpaService.addPlayer(player);
        session.setAttribute("selectedPlayer", player);

        return "redirect:/players/playermenu";
    }
    @PostMapping("/delete-player")
    public String deletePlayer(HttpSession session) {
        Player player = (Player) session.getAttribute("selectedPlayer");

        if (player != null) {
            playerJpaService.delete(player);
            session.removeAttribute("selectedPlayer");
        }

        return "redirect:/users/profile";
    }


}
