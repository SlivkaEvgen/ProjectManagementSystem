package org.example.jdbc.controller.company;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.controller.interfaces.Controller;
import org.example.jdbc.service.CompanyServiceImpl;
import org.example.jdbc.utils.Validator;

import java.util.Scanner;

public class UpdateCompanyCommand implements Controller {

    private final CompanyServiceImpl COMPANY_SERVICE = new CompanyServiceImpl();
    private final Scanner scanner = ScannerConsole.getInstance();

    private void update() {
        final String id = enterId();
        final String name = enterName();
        final String totalCost = enterTotalCost();
        COMPANY_SERVICE.update(Long.valueOf(id), name, Long.valueOf(totalCost));
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
        update();
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
