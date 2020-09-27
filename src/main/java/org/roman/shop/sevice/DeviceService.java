
package org.roman.shop.sevice;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.entity.Device;
import org.roman.shop.repository.entity.Order;
import org.roman.shop.menu.Buffer;
import org.roman.shop.repository.DeviceRepository;

import java.util.List;
import java.util.Optional;

public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService() {
        this.deviceRepository = new DeviceRepository();
    }

    public Optional<Device> findById(int deviceId) {
        return deviceRepository.findById(deviceId);
    }

    public List<Device> findForCustomer(Buffer buffer) {
        Customer customer = buffer.getCustomer();
        if (customer == null) {
            System.out.println("Please login to get actual list");
            return deviceRepository.findAllCheaperWithDiscount(Double.MAX_VALUE, 0);
        }

        return deviceRepository.findAllCheaperWithDiscount(customer.getBalance(), customer.getDiscount());
    }

    public Optional<Order> buyDevice(int id, int quantity, double price) { //Optional "забыть" про проверки на null и NullPointerException.
        Optional<Device> device = deviceRepository.findById(id);
        if (!device.isPresent()) {
            System.out.println("No device was found for id " + id);
            return Optional.empty();
        }

        int totalQuantity = device.get().getQuantity();
        if (totalQuantity < quantity) {
            System.out.println("Sorry, not enough in stock");
            return Optional.empty();
        }

        reduceQuantity(device.get(), quantity, totalQuantity);

        return Optional.of(new Order()
                .setQuantity(quantity)
                .setPrice(price)
                .setTotalAmount(quantity * price));
    }

    private Device reduceQuantity(Device device, int quantity, int totalQuantity) {
        return device.setQuantity(totalQuantity - quantity);
    }
}
