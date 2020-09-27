package org.roman.shop.repository.entity;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Customer {

    private final long id;
    @NonNull
    private final String login;
    @NonNull
    private final String password;
    private String residence;
    private int yearOfBirth;
    private double balance;
    private long discount;
    private Type type;

    public Customer(String login, String password) {
        this.id = getNextUniqueId();
        this.login = login;
        this.password = password;
    }

    public static long getNextUniqueId() {
        return System.currentTimeMillis() % 1_000_000;
    }

    public enum Type {
        REGULAR, PREMIUM
    }
}