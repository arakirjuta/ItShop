package org.roman.shop.menu.customer;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.repository.CustomerRepository;

import java.util.Scanner;

public class RegisterCommand extends CommandScreen {

    private final CustomerRepository customerRepository = new CustomerRepository();


    public RegisterCommand(Screen previousScreen, Screen nextScreen) {
        super(previousScreen, nextScreen);
    }


    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("New customer registration:");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter username.");
        String login = scanner.next();

        if (customerRepository.isLoginExists(login)) {
            System.out.println("This login already in use");
            return getPreviousScreen();
        }

        System.out.println("Please enter password.");
        String password = scanner.next();
        System.out.println("Please enter residence city.");
        String residence = scanner.next();
        System.out.println("Please enter year of birth.");
        int birthYear = scanner.nextInt();
        System.out.println("===Registration success.===");

        Customer newCustomer = createNewCustomer(login, password, residence, birthYear, 1000, 2);

        buffer.setCustomer(newCustomer);

        return getNextScreen();
    }

    private Customer createNewCustomer(String login, String password, String residence,
                                       int yearOfBirth, double startBalance, long startDiscount) {

        Customer customer = new Customer(login, password)
                .setType(Customer.Type.REGULAR)
                .setResidence(residence)
                .setYearOfBirth(yearOfBirth)
                .setBalance(startBalance)
                .setDiscount(startDiscount);

        customerRepository.saveCustomer(customer);
        return customer;
    }
}
