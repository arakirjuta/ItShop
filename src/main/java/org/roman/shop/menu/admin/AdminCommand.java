package org.roman.shop.menu.admin;

import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.common.Screen;

import java.util.Scanner;

public class AdminCommand extends CommandScreen {

    public AdminCommand(Screen previousScreen, Screen nextScreen) {
        super(previousScreen, nextScreen);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("Please login.");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter username.");
        String login = scanner.next();
        System.out.println("Please enter password.");
        String password = scanner.next();


        if (!login.equalsIgnoreCase("admin") || !password.equals("admin")) {
            System.out.println("Wrong login or password");
            buffer.incrementCounter();
            if (buffer.getCounter() >= 3) {
                buffer.resetCounter();
                return getPreviousScreen();
            }
            return this;
        }

        System.out.println("Successfully logged in");
        buffer.resetCounter();
        return getNextScreen();
    }
}
