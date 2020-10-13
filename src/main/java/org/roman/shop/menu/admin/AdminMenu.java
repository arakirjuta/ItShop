package org.roman.shop.menu.admin;

import org.roman.shop.menu.common.MenuScreen;
import org.roman.shop.menu.customer.LogoutCommand;

public class AdminMenu extends MenuScreen {

    public AdminMenu(MenuScreen returnBackMenu) {
        this.addOption(new MenuRow(1, "Order List", new AdminListOrderCommand(this)));
        this.addOption(new MenuRow(2, "Device List", new AdminDevicesListCommand(this)));   //TODO
        this.addOption(new MenuRow(3, "Customers List", new AdminCustomersListCommand(this)));
        this.addOption(new MenuRow(4, "Statistics", new AdminStatisticsCommand(this)));
        this.addOption(new MenuRow(5, "Add new device", new AdminAddNewDeviceCommand(this)));
        this.addOption(new MenuRow(6, "Logout", new LogoutCommand(this, returnBackMenu)));
    }
}
