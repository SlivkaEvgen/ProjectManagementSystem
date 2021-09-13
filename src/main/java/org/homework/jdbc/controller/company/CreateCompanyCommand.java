package org.homework.jdbc.controller.company;

import org.homework.jdbc.config.ScannerConsole;
import org.homework.jdbc.controller.interfaces.Controller;
import org.homework.jdbc.service.CompanyServiceImpl;
import org.homework.jdbc.utils.Validator;

import java.util.Scanner;

public class CreateCompanyCommand implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    private void create() {
        final String name = enterName();
        final String totalCost = enterTotalCost();
        new CompanyServiceImpl().createNewCompany(name, Long.valueOf(totalCost));
        System.out.println(" ✅ You created \uD83D\uDC49  " + "new Company " + " \n");
    }

    private String enterName() {
        System.out.print(" ENTER NAME \n\uD83D\uDC49 ");
        String name = scanner.next();
        if (!Validator.validString(name)) {
            System.out.println("Try again");
            return enterName();
        }
        return name;
    }

    private String enterTotalCost() {
        System.out.print(" ENTER TOTAL COST \n\uD83D\uDC49 ");
        String totalCost = scanner.next();
        if (!Validator.validNumber(totalCost)) {
            System.out.println("Try again");
            return enterTotalCost();
        }
        return totalCost;
    }

    @Override
    public void start() {
        create();
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
