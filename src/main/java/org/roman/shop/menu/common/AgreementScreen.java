package org.roman.shop.menu.common;

import org.roman.shop.menu.Buffer;
import org.roman.shop.repository.entity.Customer;

public class AgreementScreen extends ApproveCommandScreen {

    public AgreementScreen(Screen returnScreen) {
        super(returnScreen, returnScreen);
    }

    @Override
    protected void processApprove(Buffer buffer) {
        buffer.setApprove(true);

        if (buffer.getCustomer() != null) {
            System.out.println("Now you are PREMIUM!!!");
            buffer.getCustomer().setType(Customer.Type.PREMIUM);
        }
    }

    @Override
    public String question() {
        return "are you agree?";
    }
}
