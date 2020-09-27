package org.roman.shop;

import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.MainMenu;
import org.roman.shop.menu.common.Screen;


public class App {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Screen currentScreen = new MainMenu();
        do {
            currentScreen.printMessage(buffer);
            currentScreen = currentScreen.doAction(buffer);
        } while (currentScreen != null);

        System.out.println("Goodbye!");
    }
}
