
package org.roman.shop.sevice;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.entity.Device;
import org.roman.shop.repository.entity.Order;
import org.roman.shop.menu.Buffer;
import org.roman.shop.repository.CustomerRepository;
import org.roman.shop.repository.DeviceRepository;
import org.roman.shop.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

public class OrderService {

    private final OrderRepository orderRepository = new OrderRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final DeviceService deviceService = new DeviceService();
    private final DeviceRepository deviceRepository = new DeviceRepository();

    public void createNewOrder(Order order) {
        orderRepository.storeOrder(order);

        updateCustomerBalance(order.getCustomerId(), order.getTotalAmount());
        updateDeviceInWarehouse(order);
        System.out.println("New order  placed " + order);
    }

    private void updateDeviceInWarehouse(Order order) {
        Optional<Device> deviceById = deviceService.findById(order.getDeviceId());
        Device dev = deviceById.get();
        int oldQuantity = dev.getQuantity();
        int newQuantity = oldQuantity - order.getQuantity();
        dev.setQuantity(newQuantity);
    }


    public List<Order> findForCustomer(Buffer buffer) {
        long customerId = buffer.getCustomer().getId();

        return orderRepository.findAllBy(customerId);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    private void updateCustomerBalance(long customerId, double totalAmount) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) {
            System.out.println("Not logged user bought device");
        }

        customer.setBalance(customer.getBalance() - totalAmount);
    }

    public Optional<Order> findById(int orderId) {
        return orderRepository.findById(orderId);
    }

    public void cancelOrder(Order order) {
        order.setOrderStatus(Order.OrderStatus.CANCELLED);

        Device device = deviceRepository.findById(order.getDeviceId()).get();
        int newQuantity = order.getQuantity() + device.getQuantity();
        device.setQuantity(newQuantity);

        Customer customer = customerRepository.findById(order.getCustomerId());
        customer.setBalance(customer.getBalance() + order.getTotalAmount());
    }
}
