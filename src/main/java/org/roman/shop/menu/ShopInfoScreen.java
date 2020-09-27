package org.roman.shop.menu;

import org.roman.shop.menu.common.Screen;

import java.util.Scanner;

public class ShopInfoScreen extends Screen {
    public ShopInfoScreen(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("ItShop is an reliable store for shopping. Founded in 2020.");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        System.out.println("Please enter any key to return.");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();
        return getPreviousScreen();
    }
}
