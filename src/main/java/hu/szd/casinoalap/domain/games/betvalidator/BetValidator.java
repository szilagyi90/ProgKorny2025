package hu.szd.casinoalap.domain.games.betvalidator;

import hu.szd.casinoalap.domain.player.Player;

public class BetValidator {

    public boolean isValidBet(Player player, int betAmount, int minBet) {
        return (betAmount >= minBet && player.getCurrentChips() >= betAmount);
    }
}
