package org.roman.shop.menu.common;

import lombok.Data;
import org.roman.shop.menu.Buffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuScreen extends Screen {

    private List<MenuRow> rows = new ArrayList<>(5);

    public MenuScreen() {
        super(null, null);
    }

    protected void addOption(MenuRow row) {
        rows.add(row);
    }

    @Override
    public void printMessage(Buffer buffer) {
        System.out.println("\n==========================");
        rows.forEach(System.out::println);
        System.out.println("==========================");
    }

    @Override
    public Screen doAction(Buffer buffer) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        int userInput = scanner.nextInt();

        Optional<MenuRow> a = rows
                .stream()
                .filter(row -> row.getIndex() == userInput)
                .findFirst();

        if (!a.isPresent()) {
            return this;
        }


        return a
                .map(MenuRow::getAction)
                .orElse(getPreviousScreen());
    }

    @Data
    protected static class MenuRow {

        private final int index;
        private final String label;
        private final Screen action;

        @Override
        public String toString() {
            return index + "\t" + label;
        }
    }
}