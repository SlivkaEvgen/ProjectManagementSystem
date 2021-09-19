package org.homework.hibernate.controller.hw4.project;

import org.homework.hibernate.config.ScannerConsole;
import org.homework.hibernate.controller.hw4.interfaces.Controller;
import org.homework.hibernate.service.hw4.CompanyServiceImpl;
import org.homework.hibernate.service.hw4.CustomerServiceImpl;
import org.homework.hibernate.service.hw4.ProjectServiceImpl;
import org.homework.hibernate.utils.Validator;

import java.util.Scanner;

public class CreateProjectCommand implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    private void create() {
        final String name = enterName();
        final String cost = enterCost();
        final String companyId = enterCompanyId();
        final String customerId = enterCustomerId();
        new ProjectServiceImpl().createNewProject(name, Long.valueOf(cost),Long.valueOf(companyId),Long.valueOf(customerId));
        System.out.println(" ✅ You created \uD83D\uDC49 " + "new Project" + "\n");
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

    private String enterCost() {
        System.out.print(" ENTER COST \n\uD83D\uDC49 ");
        String cost = scanner.next();
        if (!Validator.validNumber(cost)) {
            System.out.println("Try again");
            return enterCost();
        }
        return cost;
    }

    private String enterCompanyId() {
        System.out.print(" ENTER COMPANY-ID \n\uD83D\uDC49 ");
        String companyId = scanner.next();
        try {
            if (!Validator.validNumber(companyId) | new CompanyServiceImpl().getById(Long.valueOf(companyId)).get().getId() == null) {
                System.out.println("Try again");
                return enterCompanyId();
            }
        } catch (NumberFormatException r) {
            System.out.println("Try again");
            return enterCompanyId();
        }
        return companyId;
    }

    private String enterCustomerId() {
        System.out.print(" ENTER CUSTOMER-ID \n\uD83D\uDC49 ");
        String customerId = scanner.next();
        try {
            if (!Validator.validNumber(customerId) | new CustomerServiceImpl().getById(Long.valueOf(customerId)).get().getId() == null) {
                System.out.println("Try again");
                return enterCustomerId();
            }
        } catch (NumberFormatException r) {
            System.out.println("Try again");
            return enterCustomerId();
        }
        return customerId;
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
