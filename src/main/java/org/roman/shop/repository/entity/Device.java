package org.roman.shop.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.atomic.AtomicInteger;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class Device {

    private static AtomicInteger nextId = new AtomicInteger(100);

    private final long id;
    String type;

    String manufacture;
    String model;

    private EnergyRating energyRating;
    double power;
    double noiseLevel;
    boolean portable;
    double price;
    int quantity;

    public Device() {
//        this.id = getNextUniqueId();
        this.id = nextId.getAndIncrement();
    }

    public static long getNextUniqueId() {
        return System.currentTimeMillis() % 1_000_000;
    }

    public enum EnergyRating {
        A("A"),
        A_PLUS("A+"),
        A_2PLUS("A++"),
        A_3PLUS("A+++");

        private String title;

        EnergyRating(String title) {
            this.title = title;
        }
    }
}

