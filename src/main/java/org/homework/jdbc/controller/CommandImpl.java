package org.homework.jdbc.controller;

import org.homework.jdbc.config.ScannerConsole;
import org.homework.jdbc.controller.interfaces.Controller;

import java.util.Scanner;

public class CommandImpl implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    public void start() {
        System.out.print(" HELLO!\uD83D\uDC4B\n");
        startConsole();
    }

    private void startConsole() {
        System.out.print("   \uD83D\uDC49 Start \n   \uD83D\uDC49 Stop\n\uD83D\uDC49 ");
        final String start = scanner.next();
        if (start.equalsIgnoreCase("start")) {
            new ControllerImpl().start();
        }
        if (start.equalsIgnoreCase("stop")) {
            close();
        } else {
            System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
            startConsole();
        }
    }

    public void close() {
        System.exit(0);
        scanner.close();
    }
}
