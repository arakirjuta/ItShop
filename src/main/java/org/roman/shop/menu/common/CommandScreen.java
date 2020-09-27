package org.roman.shop.menu.common;

public abstract class CommandScreen extends Screen {

    public CommandScreen(Screen previousScreen, Screen nextScreen) {
        super(previousScreen, nextScreen);
    }
}