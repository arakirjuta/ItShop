package org.roman.shop.menu;


import org.roman.shop.menu.common.ApproveCommandScreen;
import org.roman.shop.menu.common.Screen;

public class ExitCommand extends ApproveCommandScreen {

    public ExitCommand(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    protected void processApprove(Buffer buffer) {
        buffer.setCustomer(null);
    }

    @Override
    public String question() {
        return "Are you sure you want to EXIT?";
    }
}

