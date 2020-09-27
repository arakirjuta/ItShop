package org.roman.shop.menu.customer;

import org.roman.shop.repository.entity.Device;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.sevice.DeviceService;

import java.util.Scanner;

public class DeviceListCommand extends CommandScreen {

    private DeviceService service = new DeviceService();

    public DeviceListCommand(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("List of suitable devices for you:");
        service.findForCustomer(buffer).forEach(this::showDevice);
    }

    private void showDevice(Device x) {
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
