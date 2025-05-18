package hu.szd.casinoalap.domain.player;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final int id;

    private final String username;
    private int currentChips;
    private int totalGeneratedChips;
    private final String password;

    public Player(int id, String username, int chips, int totalGeneratedChips, String password) {
        this.id = id;
        this.username = username;
        this.currentChips = chips;
        this.totalGeneratedChips = totalGeneratedChips;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return  "id= " + id +
                ", username= " + username +
                ", jelenlegi zseton mennyiség= " + currentChips +
                ", összesen vásárolt zseton= " + totalGeneratedChips;
    }
}
