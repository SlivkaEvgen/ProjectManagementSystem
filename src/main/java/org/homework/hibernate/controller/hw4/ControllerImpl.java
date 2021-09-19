package org.homework.hibernate.controller.hw4;

import org.homework.hibernate.controller.hw4.company.CompanyCommandImpl;
import org.homework.hibernate.controller.hw4.project.ProjectCommandImpl;
import org.homework.hibernate.controller.hw4.skill.SkillCommandImpl;
import org.homework.hibernate.config.ScannerConsole;
import org.homework.hibernate.controller.hw4.customer.CustomerCommandImpl;
import org.homework.hibernate.controller.hw4.developer.DeveloperCommandImpl;
import org.homework.hibernate.controller.hw4.interfaces.Controller;

import java.util.Scanner;

public class ControllerImpl implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    @Override
    public void start() {
        System.out.print("\n \uD83D\uDC49 DEVELOPER\n \uD83D\uDC49 PROJECT\n \uD83D\uDC49 COMPANY\n \uD83D\uDC49 CUSTOMER\n \uD83D\uDC49 SKILL\n   \uD83D\uDC49 BACK\n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
        final String controller = scanner.next();
        if (controller.isEmpty()) {
            close();
        }
        if (controller.equalsIgnoreCase("DEVELOPER")) {
            new DeveloperCommandImpl().start();
        }
        if (controller.equalsIgnoreCase("PROJECT")) {
            new ProjectCommandImpl().start();
        }
        if (controller.equalsIgnoreCase("COMPANY")) {
            new CompanyCommandImpl().start();
        }
        if (controller.equalsIgnoreCase("CUSTOMER")) {
            new CustomerCommandImpl().start();
        }
        if (controller.equalsIgnoreCase("SKILL")) {
            new SkillCommandImpl().start();
        }
        if (controller.equalsIgnoreCase("BACK")) {
            new CommandImpl().start();
        }
        if (controller.equalsIgnoreCase("STOP")) {
            close();
        } else {
            System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
            start();
        }
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
