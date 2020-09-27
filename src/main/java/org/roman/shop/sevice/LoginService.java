package org.roman.shop.sevice;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.CustomerRepository;

public class LoginService {

    private final CustomerRepository customerRepository;

    public LoginService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer login(String login, String password) {

        Customer byLogin = customerRepository.findByLogin(login);
        if (byLogin == null) {
            System.out.println("User not exists or not found by login " + login);
            return null;
        }

        if (customerRepository.isPasswordMatch(byLogin, password)) {
            return byLogin;
        }

        System.out.println("Wrong password entered, please check");
        return null;
    }
}
