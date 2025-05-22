package hu.szd.casinoalap.domain.player;

import jakarta.persistence.*;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String playerName;
    @Column(name="Current_chips")
    private int currentChips;
    @Column(name="Total_generated_chips")
    private int totalGeneratedChips;

    public Player(){

    }

    public Player(String playerName, int chips, int totalGeneratedChips, User user) {
        this.playerName = playerName;
        this.currentChips = chips;
        this.totalGeneratedChips = totalGeneratedChips;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getCurrentChips() {
        return currentChips;
    }

    public void setCurrentChips(int currentChips) {
        this.currentChips = currentChips;
    }

    public int getTotalGeneratedChips() {
        return totalGeneratedChips;
    }

    public void setTotalGeneratedChips(int totalGeneratedChips) { this.totalGeneratedChips = totalGeneratedChips; }

}
