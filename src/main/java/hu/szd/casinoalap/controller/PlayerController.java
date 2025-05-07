package hu.szd.casinoalap.controller;

import hu.szd.casinoalap.domain.player.Player;
import hu.szd.casinoalap.repository.PlayerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }


//    @GetMapping("/login")
//    public String getPlayers(Model model){
//        List<Player> PLAYERS = playerRepository.getAllPlayers();
//        model.addAttribute("players", PLAYERS);
//        return "login";
    //}
    @GetMapping("/login")
    public String showLoginForm() {
        return "players/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Player player = playerRepository.findPlayerByUsername(username);
        if (player != null && player.getPassword().equals(password)) {
            model.addAttribute("username", player.getUsername());
            return "index";
        } else {
            return "players/login?error";
        }
    }

    //create player HTML page
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


//    @GetMapping("/delete/{id}")
//    public String deletePlayer(Model model, @PathVariable int id){
//        Player player = playerRepository.findPlayerById(id);
//        playerRepository.deletePlayer(player);
//        List<Player> PLAYERS = playerRepository.getAllPlayers();
//        model.addAttribute("players", PLAYERS);
//        return "players/list";
//    }
}
