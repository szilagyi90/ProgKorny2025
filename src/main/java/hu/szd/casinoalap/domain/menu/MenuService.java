package hu.szd.casinoalap.domain.menu;

public class MenuService {
    private final Menu menu;

    public MenuService(Menu menu) {
        this.menu = menu;
    }

    public void start() {
        menu.showMenu();
    }
}
