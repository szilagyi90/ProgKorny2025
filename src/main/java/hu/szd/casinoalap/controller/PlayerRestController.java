//package hu.szd.casinoalap.controller;
//
//import hu.szd.casinoalap.domain.player.Player;
//import hu.szd.casinoalap.repository.PlayerRepository;
//import hu.szd.casinoalap.services.PlayerService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/players")
//@SessionAttributes("player")
//public class PlayerRestController {
//    private final PlayerRepository playerRepository;
//
//    public PlayerRestController(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }
//    @GetMapping("/list")
//    public ResponseEntity<List<Player>> getPlayers(){
//        List<Player> players = playerRepository.getAllPlayers();
//      //  throw new IllegalArgumentException("valami nem működött");
//        return ResponseEntity.ok(players);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Player> getPlayer(@PathVariable int id){
//        Player player = playerRepository.findPlayerById(id);
//        return ResponseEntity.ok(player);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Player> createProduct(@RequestBody Player player) {
//        playerRepository.addPlayer(player);
//        return ResponseEntity.ok().build();
//    }
//    @PutMapping("/update")
//    public ResponseEntity<Player> updateProduct(@RequestBody Player player) {
//        playerRepository.updatePlayer(player);
//        return ResponseEntity.ok().build();
//    }
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<Void> deletePlayer(@RequestBody Player player) {
//        playerRepository.deletePlayer(player);
//        return ResponseEntity.ok().build();
//    }
//}
