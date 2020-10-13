package org.roman.shop.menu.admin;

import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.repository.CustomerRepository;
import org.roman.shop.repository.DeviceRepository;
import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.entity.Device;

import java.util.Scanner;

public class AdminDevicesListCommand extends CommandScreen {

    private DeviceRepository repository = new DeviceRepository();

    public AdminDevicesListCommand(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("List of all devices:");
        repository.findAll().forEach(this::showDevice);
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
