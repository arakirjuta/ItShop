package org.roman.shop.menu;

import org.roman.shop.menu.admin.AdminCommand;
import org.roman.shop.menu.admin.AdminMenu;
import org.roman.shop.menu.common.MenuScreen;
import org.roman.shop.menu.common.Screen;
import org.roman.shop.menu.customer.CustomerMenu;
import org.roman.shop.menu.customer.LoginCommand;
import org.roman.shop.menu.customer.RegisterCommand;

public class MainMenu extends MenuScreen {

    public MainMenu() {
        Screen customerMenu = new CustomerMenu(this);
        Screen adminMenu = new AdminMenu(this);

        this.addOption(new MenuRow(1, "Register", new RegisterCommand(this, customerMenu)));
        this.addOption(new MenuRow(2, "Login", new LoginCommand(this, customerMenu)));
        this.addOption(new MenuRow(3, "About ItShop", new ShopInfoScreen(this)));
        this.addOption(new MenuRow(4, "Exit", new ExitCommand(this)));
        this.addOption(new MenuRow(5, "ADMIN", new AdminCommand(this, adminMenu)));
    }
}
