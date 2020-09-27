package org.roman.shop.menu.customer;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.repository.CustomerRepository;
import org.roman.shop.sevice.LoginService;

import java.util.Scanner;

public class LoginCommand extends CommandScreen {

    private LoginService service = new LoginService(new CustomerRepository());

    public LoginCommand(Screen previousScreen, Screen nextScreen) {
        super(previousScreen, nextScreen);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("Please login.");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter username.");
        String login = scanner.next();
        System.out.println("Please enter password.");
        String password = scanner.next();


        Customer customer = service.login(login, password);
        if (customer == null) {
            System.out.println("Wrong login or password");
            buffer.incrementCounter();
            if (buffer.getCounter() >= 3) {
                buffer.resetCounter();
                return getPreviousScreen();
            }
            return this;
        }

        System.out.println("Successfully logged in");
        buffer.setCustomer(customer);
        buffer.resetCounter();
        return getNextScreen();
    }
}
