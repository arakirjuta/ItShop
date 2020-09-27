package org.roman.shop.repository;

import org.apache.commons.lang3.StringUtils;
import org.roman.shop.repository.entity.Customer;

import java.util.List;

//crud
public class CustomerRepository {

    public Customer findById(long id) {
        return DataSource.customers
                .stream()
                .filter(x -> x.getId() == id)
                .findAny()
                .orElse(null);
    }

    public Customer findByLogin(String login) {
        return DataSource.customers
                .stream()
                .filter(x -> StringUtils.equals(x.getLogin(), login))
                .findAny()
                .orElse(null);
    }

    public List<Customer> findAll() {
        return DataSource.customers;
    }

    public boolean isPasswordMatch(Customer customer, String password) {
        return StringUtils.equals(customer.getPassword(), password);
    }

    public void saveCustomer(Customer customer) {
        DataSource.customers.add(customer);
    }

    public boolean isLoginExists(String login) {
        return DataSource.customers
                .stream()
                .anyMatch(x -> x.getLogin().equals(login));
    }
}
