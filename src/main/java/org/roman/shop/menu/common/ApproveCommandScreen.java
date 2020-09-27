package org.roman.shop.menu.common;

import org.roman.shop.menu.Buffer;

import java.util.Scanner;

public abstract class ApproveCommandScreen extends CommandScreen {

    public ApproveCommandScreen(Screen declineScreen, Screen approveScreen) {
        super(declineScreen, approveScreen);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println(question() + " [Y/N]");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        Scanner scanner = new Scanner(System.in);

        String response = scanner.next();
        if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
            processApprove(buffer);
            return getNextScreen();
        }
        return getPreviousScreen();
    }

    protected abstract void processApprove(Buffer buffer);

    public abstract String question();
}

