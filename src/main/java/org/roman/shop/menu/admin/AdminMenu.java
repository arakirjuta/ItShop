package org.roman.shop.menu.admin;

import org.roman.shop.menu.common.MenuScreen;
import org.roman.shop.menu.customer.LogoutCommand;

public class AdminMenu extends MenuScreen {

    public AdminMenu(MenuScreen returnBackMenu) {
        this.addOption(new MenuRow(1, "Order List", new AdminListOrderCommand(this)));
        this.addOption(new MenuRow(2, "Customers List", new AdminCustomersListCommand(this)));
        this.addOption(new MenuRow(3, "Statistics", new AdminStatisticsCommand(this)));
        this.addOption(new MenuRow(4, "Logout", new LogoutCommand(this, returnBackMenu)));
    }
}
