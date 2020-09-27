package org.roman.shop.menu;

import lombok.Data;
import org.roman.shop.repository.entity.Customer;

@Data
public class Buffer {

    private Customer customer;
    private boolean approve;
    private Integer counter;

    public void incrementCounter() {
        if (counter == null) {
            counter = 0;
        }
        counter++;
    }

    public void resetCounter() {
        counter = null;
    }
}
