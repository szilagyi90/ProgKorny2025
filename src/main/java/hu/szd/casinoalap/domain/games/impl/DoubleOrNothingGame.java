package hu.szd.casinoalap.domain.games.impl;

import hu.szd.casinoalap.domain.games.Game;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class DoubleOrNothingGame implements Game {

    private final Random random = new Random();

    @Override
    public int minimumBet() {
        return 10;
    }

    @Override
    public String name() {
        return "Double-or-Nothing";
    }

    @Override
    public double play() {

        int multiplier;
        boolean win = Math.random() < 0.5;
        if (win) {
            multiplier = 1;
        } else {
            multiplier = -1;
        }
        return multiplier;
    }

}

