package hu.szd.casinoalap.domain.modul;

import hu.szd.casinoalap.domain.player.Player;
import org.springframework.stereotype.Component;

@Component
public class BetValidator {

    public boolean isValidBet(Player player, int bet, int minBet) {
        return (bet >= minBet && player.getCurrentChips() >= bet);
    }
}
