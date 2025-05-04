package hu.szd.casinoalap;

import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.menu.impl.PlayerSelectionMenu;

public class Main {
    public static void main(String[] args) {
        Menu login = new PlayerSelectionMenu();
        login.showMenu();;
        }
    }