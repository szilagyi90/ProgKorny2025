package hu.szd.casinoalap.domain.player;

public class Player {

    private final int id;
    private final String username;
    private int currentChips;
    private int totalGeneratedChips;

    public Player(int id, String username, int chips, int totalGeneratedChips) {
        this.id = id;
        this.username = username;
        this.currentChips = chips;
        this.totalGeneratedChips = totalGeneratedChips;
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

    public void setTotalGeneratedChips(int totalGeneratedChips) {
        this.totalGeneratedChips = totalGeneratedChips;
    }


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", jelenlegi zseton mennyiség=" + currentChips +
                ", összesen vásárolt zseton=" + totalGeneratedChips +
                '}';
    }
}
