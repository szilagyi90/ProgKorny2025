package hu.szd.casinoalap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Menu login = context.getBean(PlayerSelectionMenu.class);
//        login.showMenu();

    }
    }