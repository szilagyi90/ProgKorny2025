package hu.szd.casinoalap.domain.service;

import hu.szd.casinoalap.domain.player.Player;
import org.springframework.stereotype.Component;


public class BetValidator {

    public boolean isValidBet(Player player, int betAmount, int minBet) {
        return (betAmount >= minBet && player.getCurrentChips() >= betAmount);
    }
}
