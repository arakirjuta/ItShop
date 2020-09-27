package org.roman.shop.menu.common;

import lombok.Data;
import org.roman.shop.menu.Buffer;

@Data
public abstract class Screen {

    private final Screen previousScreen;
    private final Screen nextScreen;

    public abstract void printMessage(Buffer buffer);

    public abstract Screen doAction(Buffer buffer);
}
