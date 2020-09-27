package org.roman.shop.menu.customer;

import org.roman.shop.menu.common.ApproveCommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;

public class LogoutCommand extends ApproveCommandScreen {

    public LogoutCommand(Screen declineScreen, Screen approveScreen) {
        super(declineScreen, approveScreen);
    }

    @Override
    protected void processApprove(Buffer buffer) {
        buffer.setCustomer(null);
    }

    @Override
    public String question() {
        return "Are you sure you want to LOGOUT?";
    }
}
