package org.homework.hibernate.controller.hw4.company;

import org.homework.hibernate.config.ScannerConsole;
import org.homework.hibernate.controller.hw4.interfaces.Controller;
import org.homework.hibernate.service.hw4.CompanyServiceImpl;
import org.homework.hibernate.utils.Validator;

import java.util.Scanner;

public class CreateCompanyCommand implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    private void create() {
        final String name = enterName();
        final String city = enterCity();
        new CompanyServiceImpl().createNewCompany(name, city);
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

    private String enterCity() {
        System.out.print(" ENTER CITY \n\uD83D\uDC49 ");
        String city = scanner.next();
        if (!Validator.validString(city)) {
            System.out.println("Try again");
            return enterCity();
        }
        return city;
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
