package org.roman.shop.repository.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Order {

    long id;
    int quantity;
    double price;
    double totalAmount;
    long customerId;
    int deviceId;
    private OrderStatus orderStatus;

    public enum OrderStatus {
        DONE,
        CANCELLED;
    }

    public Order() {
        this.id = getNetUniqueId();
    }

    private long getNetUniqueId() {
        return System.currentTimeMillis() % 1_000_000;
    }
}

