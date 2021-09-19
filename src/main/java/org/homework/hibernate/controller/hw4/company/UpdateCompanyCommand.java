package org.homework.hibernate.controller.hw4.company;

import org.homework.hibernate.config.ScannerConsole;
import org.homework.hibernate.controller.hw4.interfaces.Controller;
import org.homework.hibernate.service.hw4.CompanyServiceImpl;
import org.homework.hibernate.utils.Validator;

import java.util.Scanner;

public class UpdateCompanyCommand implements Controller {

    private final CompanyServiceImpl COMPANY_SERVICE = new CompanyServiceImpl();
    private final Scanner scanner = ScannerConsole.getInstance();

    private void update() {
        final String id = enterId();
        final String name = enterName();
        final String city = enterCity();
        COMPANY_SERVICE.update(Long.valueOf(id), name, city);
        System.out.println(" ✅ You updated \uD83D\uDC49 " + COMPANY_SERVICE.getById(Long.valueOf(id)).get() + "\n");
    }

    private String enterId() {
        System.out.print(" ENTER ID \n\uD83D\uDC49 ");
        String id = scanner.next();
        if (!Validator.validNumber(id) || COMPANY_SERVICE.getById(Long.valueOf(id)).get().getId() == null) {
            System.out.println("Try again");
            return enterId();
        }
        return id;
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
        update();
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
