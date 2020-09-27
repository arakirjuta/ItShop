package org.roman.shop.repository;

import org.roman.shop.repository.entity.Order;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//crud
public class OrderRepository {

    public void storeOrder(Order order) {
        DataSource.orders.add(order);
    }

    public List<Order> findAllBy(long customerId) {
        return DataSource.orders
                .stream()
                .filter(x -> x.getCustomerId() == customerId)
                .collect(Collectors.toList());
    }

    public int findNumberOfOrders() {
        return DataSource.orders.size();

    }

    public Optional<Order> findById(int id) {
        return DataSource.orders
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }

    public List<Order> findAll() {
        return DataSource.orders;
    }
}
