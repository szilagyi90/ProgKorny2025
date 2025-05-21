//package hu.szd.casinoalap.controller;
//
//import hu.szd.casinoalap.domain.player.Player;
//import hu.szd.casinoalap.services.GameService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/games")
//@SessionAttributes("player")
//public class GameController {
//    private final GameService gameService;
//
//    public GameController(GameService gameService) {
//        this.gameService = gameService;
//    }
//
//    @GetMapping("/Double-or-Nothing")
//    public String showGameForm(
//            @SessionAttribute("player") Player player,
//            @RequestParam(required = false) boolean error,
//            Model model) {
//        int minBet = gameService.getMinimumBet("Double-or-Nothing");
//        model.addAttribute("minBet", minBet);
//        model.addAttribute("error", error);
//        return "games/Double-or-Nothing";
//    }
//
//    @PostMapping("/Double-or-Nothing")
//    public String playGame(
//            @SessionAttribute("player") Player player,
//            @RequestParam int bet,
//            Model model) {
//        int delta;
//        try {
//            delta = gameService.play("Double-or-Nothing", player, bet);
//        } catch (IllegalArgumentException e) {
//            return "redirect:/games/Double-or-Nothing?error=true";
//        }
//        model.addAttribute("delta", delta);
//        model.addAttribute("player", player);
//        return "games/Double-or-Nothing";
//    }
//}
