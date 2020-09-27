package org.roman.shop.menu.admin;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.repository.CustomerRepository;

import java.util.Scanner;

public class AdminCustomersListCommand extends CommandScreen {

    private CustomerRepository repository = new CustomerRepository();

    public AdminCustomersListCommand(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("List of all customers:");
        repository.findAll().forEach(this::showCustomer);
    }

    private void showCustomer(Customer x) {
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
