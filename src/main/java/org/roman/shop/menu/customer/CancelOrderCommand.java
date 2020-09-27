package org.roman.shop.menu.customer;

import org.roman.shop.repository.entity.Order;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.sevice.OrderService;

import java.util.Optional;
import java.util.Scanner;

public class CancelOrderCommand extends CommandScreen {

    private OrderService orderService = new OrderService();

    public CancelOrderCommand(Screen previousScreen, Screen nextScreen) {
        super(previousScreen, nextScreen);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("Cancelling order.");
    }

    @Override
    public Screen doAction(Buffer buffer) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure to cancel this order? [Y/N]");

        String response = scanner.next();
        if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("y")) {
            System.out.println("Sad....");
            return getPreviousScreen();
        }

        System.out.println("Please enter order number.");
        int orderId = scanner.nextInt();

        Optional<Order> orderWrappedByOptional = orderService.findById(orderId);
        if (!orderWrappedByOptional.isPresent()) {
            System.out.println("No order was found");
            return getPreviousScreen();
        }

        Order order = orderWrappedByOptional.get();
        if (buffer.getCustomer().getId() != order.getCustomerId()) {
            System.out.println("This order doesn't belong to you.");
            return getPreviousScreen();
        }

        if(order.getOrderStatus() == Order.OrderStatus.CANCELLED){
            System.out.println("Order is already cancelled!.");
            return getPreviousScreen();
        }

        orderService.cancelOrder(orderWrappedByOptional.get());
        System.out.println("Yours order has been cancelled! Your balance is: " + buffer.getCustomer().getBalance());
        return getPreviousScreen();
    }
}