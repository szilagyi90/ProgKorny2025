package hu.szd.casinoalap.domain.service;

import hu.szd.casinoalap.domain.player.Player;

public class ChipGenerator {

    public void generateChip(Player player, int amount){
        player.setCurrentChips(player.getCurrentChips() + amount);
        player.setTotalGeneratedChips(player.getTotalGeneratedChips() + amount);
    }
}
