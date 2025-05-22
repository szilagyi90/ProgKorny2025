package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.games.Game;
import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.services.imp.GameServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {
    private final GameServiceImpl gameService;

    public GameController(GameServiceImpl gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/Double-or-Nothing")
    public String showGameForm(
            HttpSession session,
            Model model) {
        Player player = (Player) session.getAttribute("selectedPlayer");
        Game game = gameService.findGameByName("Double-or-Nothing");
        int minBet = game.minimumBet();
        model.addAttribute("minBet", minBet);
        model.addAttribute("player", player);
        return "games/Double-or-Nothing";
    }

    @PostMapping("/Double-or-Nothing")
    public String playGame(
            HttpSession session,
            @RequestParam int bet,
            @RequestParam(required = false) boolean error,
            Model model) {
        Player player = (Player) session.getAttribute("selectedPlayer");
        Game game = gameService.findGameByName("Double-or-Nothing");
        int delta;
        try {
            delta = gameService.play("Double-or-Nothing", player, bet);
        } catch (IllegalArgumentException e) {
            return "redirect:/games/Double-or-Nothing?error=true";
        }
        session.setAttribute("selectedPlayer", player);
        model.addAttribute("delta", delta);
        model.addAttribute("player", player);
        model.addAttribute("minBet", game.minimumBet());
        return "games/Double-or-Nothing";
    }
}
