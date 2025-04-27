package hu.szd.casinoalap;

import hu.szd.casinoalap.controller.imp.PlayerControllerImp;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.menu.MenuService;
import hu.szd.casinoalap.domain.menu.imp.PlayerSelectionMenu;
import hu.szd.casinoalap.repository.PlayerRepository;
import hu.szd.casinoalap.repository.imp.PlayerRepositoryImp;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepositoryImp();
        PlayerControllerImp playerController = new PlayerControllerImp(playerRepository);
        Menu menu = new PlayerSelectionMenu(playerController, playerRepository);
        MenuService menuService = new MenuService(menu);

        menuService.start();
    }
    }