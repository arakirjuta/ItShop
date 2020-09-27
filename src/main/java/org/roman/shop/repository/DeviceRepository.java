package org.roman.shop.repository;

import org.roman.shop.repository.entity.Device;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DeviceRepository {

    public List<Device> findAllCheaperThen(double price) {
        return DataSource.devices
                .stream()
                .filter(x -> x.getPrice() <= price)
                .collect(Collectors.toList());
    }

    public List<Device> findAllCheaperWithDiscount(double price, long discount) {
        return DataSource.devices
                .stream()
                .filter(x -> x.getPrice() * (1 - (float) discount / 100) - 0.01 < price)
                .collect(Collectors.toList());
    }


    public Optional<Device> findById(int id) {
        return DataSource.devices
                .stream()
                .filter(x -> x.getId() == id)
                .findFirst();
    }
}
