package org.roman.shop.menu.customer;

import org.roman.shop.repository.entity.Order;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.sevice.OrderService;

import java.util.Scanner;

public class OrderListCommand extends CommandScreen {

    private OrderService service = new OrderService();

    public OrderListCommand(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("List of yours orders:");
        service.findForCustomer(buffer).forEach(this::showOrder);
    }

    private void showOrder(Order x) {
        System.out.println(x);
    }

    @Override
    public Screen doAction(Buffer buffer) {
        System.out.println("please any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        return getPreviousScreen();
    }
}
