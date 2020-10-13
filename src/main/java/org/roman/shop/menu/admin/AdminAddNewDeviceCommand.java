package org.roman.shop.menu.admin;

import org.apache.commons.lang3.EnumUtils;
import org.roman.shop.menu.Buffer;
import org.roman.shop.menu.common.CommandScreen;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.repository.DeviceRepository;
import org.roman.shop.repository.entity.Customer;
import org.roman.shop.repository.entity.Device;

import java.util.Scanner;

public class AdminAddNewDeviceCommand extends CommandScreen {


    public AdminAddNewDeviceCommand(Screen previousScreen) {
        super(previousScreen, previousScreen);
    } //TODO check is it OK

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("<<< Adding new device. >>>");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter device type.");
        String type = scanner.next();
        System.out.println("Please enter manufacture.");
        String manufacture = scanner.next();
        System.out.println("Please enter model.");
        String model = scanner.next();
        System.out.println("Please enter energyRating.");
        String energyRating = scanner.next();
        System.out.println("Please enter power.");
        int power = scanner.nextInt();
        System.out.println("Please enter noiseLevel.");
        int noiseLevel = scanner.nextInt();
        System.out.println("Please enter whether the device is portable.");
        boolean portable = scanner.nextBoolean();
        System.out.println("Please enter the device price.");
        int price = scanner.nextInt();
        System.out.println("Please enter the device quantity.");
        int quantity = scanner.nextInt();
        System.out.println("<<< A new device added successfully. >>>");

        Device newDevice = createNewDevice(type, manufacture, model, EnumUtils.getEnum(Device.EnergyRating.class, energyRating, Device.EnergyRating.A), power, noiseLevel,
                portable, price, quantity);

        return getNextScreen();
    }

    private Device createNewDevice(String type, String manufacture, String model, Device.EnergyRating energyRating,
                                   double power, double noiseLevel, boolean portable, double price, int quantity) {

        Device device = new Device()
                .setType(type)
                .setManufacture(manufacture)
                .setModel(model)
                .setEnergyRating(energyRating)
                .setPower(power)
                .setNoiseLevel(noiseLevel)
                .setPortable(portable)
                .setPrice(price)
                .setQuantity(quantity);


        DeviceRepository.saveDevice(device);
        return device;
    }

}
