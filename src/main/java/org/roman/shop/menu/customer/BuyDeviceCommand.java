package org.roman.shop.menu.customer;

import org.roman.shop.repository.entity.Device;
import org.roman.shop.repository.entity.Order;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.sevice.DeviceService;
import org.roman.shop.sevice.OrderService;

import java.util.Optional;
import java.util.Scanner;

public class BuyDeviceCommand extends CommandScreen {

    private OrderService orderService = new OrderService();
    private DeviceService service = new DeviceService();

    public BuyDeviceCommand(Screen previousScreen, Screen nextScreen) {
        super(previousScreen, nextScreen);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("Please choose device to buy");
    }

    @Override
    public Screen doAction(Buffer buffer) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you ready to buy? [Y/N]");

        String response = scanner.next();
        if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("y")) {
            System.out.println("Sad....");
            return getPreviousScreen();
        }

        System.out.println("Please enter device id");
        int deviceId = scanner.nextInt();

        Optional<Device> deviceById = service.findById(deviceId);
        if (!deviceById.isPresent()) {
            System.out.println("No device was found");
            return getPreviousScreen();
        }

        Device device = deviceById.get();

        System.out.println("Please enter quantity");
        int quantity = scanner.nextInt();
        if (quantity > device.getQuantity()) {
            System.out.println("Not enough in stock");
            return getPreviousScreen();
        }

        double price = (device.getPrice() / 100) * (100 - buffer.getCustomer().getDiscount());
        double totalPrice = price * quantity;
        if (buffer.getCustomer().getBalance() < totalPrice) {
            System.out.println("Not sufficient funds");
            return getPreviousScreen();
        }


        Order order = new Order()
                .setOrderStatus(Order.OrderStatus.DONE)
                .setDeviceId(deviceId)
                .setPrice(price)
                .setQuantity(quantity)
                .setTotalAmount(totalPrice)
                .setCustomerId(getCustomerId(buffer));

        orderService.createNewOrder(order);
        return getNextScreen();
    }

    private long getCustomerId(Buffer buffer) {
        if (buffer.getCustomer() == null) {
            return -1;
        }

        return buffer.getCustomer().getId();
    }
}
