package org.roman.shop.repository;

import com.google.common.collect.Lists;
import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.entity.Device;
import org.roman.shop.repository.entity.Order;

import java.util.List;


class DataSource {

    public static List<Customer> customers = Lists.newArrayList(
            new Customer(1, "test1", "secret1", "Tallinn", 1986, 10000, 15, Customer.Type.PREMIUM),
            new Customer(2, "test2", "secret2", "Tartu", 1999, 5000, 0, Customer.Type.REGULAR)

    );

    public static List<Device> devices = Lists.newArrayList(
            new Device(1, "refrigerator", "Miele", "Retro1999", Device.EnergyRating.A_3PLUS, 2000, 45, false, 500, 2),
            new Device(2, "washer", "Bosch", "AX-12", Device.EnergyRating.A_2PLUS, 1800, 43, false, 900, 5),
            new Device(3, "mixer", "Bosch", "KER", Device.EnergyRating.A_2PLUS, 400, 33, true, 90, 10),
            new Device(4, "toaster", "Elektrolux", "AS-18LM", Device.EnergyRating.A ,500, 12, true, 70, 30)
            );

    public static List<Order> orders = Lists.newArrayList();
}
