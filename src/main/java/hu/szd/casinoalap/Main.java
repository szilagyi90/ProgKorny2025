package hu.szd.casinoalap;

import hu.szd.casinoalap.controller.RepositoryController;
import hu.szd.casinoalap.controller.imp.RepositoryControllerImpl;
import hu.szd.casinoalap.domain.menu.MenuService;
import hu.szd.casinoalap.domain.menu.impl.PlayerSelectionMenu;
import hu.szd.casinoalap.repository.PlayerRepository;
import hu.szd.casinoalap.repository.impl.PlayerRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepositoryImpl();
        RepositoryController repositoryController = new RepositoryControllerImpl(playerRepository);

        MenuService menuService = new MenuService(new PlayerSelectionMenu(repositoryController));
        menuService.start();
        }
    }