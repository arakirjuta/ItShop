package org.roman.shop.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    int id;
    String type;

    String manufacture;
    String model;

    private EnergyRating energyRating;
    double power;
    double noiseLevel;
    boolean portable;
    double price;
    int quantity;

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

