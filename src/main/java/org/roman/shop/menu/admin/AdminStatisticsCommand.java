package org.roman.shop.menu.admin;

import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.entity.Order;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.repository.CustomerRepository;

import org.roman.shop.repository.OrderRepository;

import java.util.DoubleSummaryStatistics;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AdminStatisticsCommand extends CommandScreen {

    private CustomerRepository customerRepository = new CustomerRepository();
    private OrderRepository orderRepository = new OrderRepository();

    public AdminStatisticsCommand(Screen returnScreen) {
        super(returnScreen, null);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("====== Statistics data ========" + "\n");
        showOrdersStats(Order.OrderStatus.DONE);
        System.out.println("================================");
        showOrdersStats(Order.OrderStatus.CANCELLED);
        System.out.println("================================");

        showStatsByRegions();
        System.out.println("================================");
        showStatsByCustomer();
        System.out.println("================================");
    }

    private void showOrdersStats(Order.OrderStatus status) {
        DoubleSummaryStatistics statistics = orderRepository.findAll()
                .stream()
                .filter(order -> order.getOrderStatus() == status)
                .mapToDouble(Order::getTotalAmount)
                .summaryStatistics();


        if (statistics.getCount() == 0) {  //if no orders
            return;
        }

        System.out.println("Orders statistics " + status);
        System.out.println("Total number of orders: " + statistics.getCount());
        System.out.println("Average order: " + statistics.getAverage());
        System.out.println("Max order: " + statistics.getMax());
        System.out.println("Min order: " + statistics.getMin());
        System.out.println("Sum: " + statistics.getSum());
    }

    private void showStatsByRegions() {
        Map<String, Long> groupedByRegions = customerRepository.findAll()
                .stream()
                .map(Customer::getResidence)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));

        System.out.println("Regions distribution: " + groupedByRegions);
    }

    private void showStatsByCustomer() {
        Map<Integer, Long> groupedByAge = customerRepository.findAll()
                .stream()
                .map(Customer::getYearOfBirth)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));

        System.out.println("Age distribution: " + groupedByAge);
    }

    private void showCustomer(Customer x) {
        System.out.println(x);
    }

    @Override
    public Screen doAction(Buffer buffer) {
        System.out.println("please any key to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        return getPreviousScreen();
    }
}
