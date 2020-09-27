package org.roman.shop.menu.customer;

import org.roman.shop.menu.ShopInfoScreen;
import org.roman.shop.menu.common.AgreementScreen;
import org.roman.shop.menu.common.MenuScreen;
import org.roman.shop.menu.common.Screen;

public class CustomerMenu extends MenuScreen {

    public CustomerMenu(Screen returnBackMenu) {
        this.addOption(new MenuRow(1, "Device List ", new DeviceListCommand(this)));
        this.addOption(new MenuRow(2, "Buy device", new BuyDeviceCommand(this, this)));
        this.addOption(new MenuRow(3, "Order List", new OrderListCommand(this)));
        this.addOption(new MenuRow(4, "Cancel order", new CancelOrderCommand(this, this)));
        this.addOption(new MenuRow(5, "About", new ShopInfoScreen(this)));
        this.addOption(new MenuRow(6, "Logout", new LogoutCommand(this, returnBackMenu)));
        this.addOption(new MenuRow(7, "Special Offer!!!! Become premium", new AgreementScreen(this)));
    }
}
