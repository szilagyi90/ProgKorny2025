package hu.szd.casinoalap;

import hu.szd.casinoalap.config.AppConfig;
import hu.szd.casinoalap.domain.menu.Menu;
import hu.szd.casinoalap.domain.menu.impl.PlayerSelectionMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Menu login = context.getBean(PlayerSelectionMenu.class);
        login.showMenu();

    }
    }