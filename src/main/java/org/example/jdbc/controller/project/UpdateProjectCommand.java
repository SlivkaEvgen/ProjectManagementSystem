package org.example.jdbc.controller.project;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.utils.Validator;
import org.example.jdbc.controller.interfaces.Controller;
import org.example.jdbc.service.CompanyServiceImpl;
import org.example.jdbc.service.CustomerServiceImpl;
import org.example.jdbc.service.ProjectServiceImpl;

import java.util.Scanner;

public class UpdateProjectCommand implements Controller {

    private final ProjectServiceImpl PROJECT_SERVICE = new ProjectServiceImpl();
    private final Scanner scanner = ScannerConsole.getInstance();

    private void update() {
        final String id = enterId();
        final String name = enterName();
        final String cost = enterCost();
        final String companyId = enterCompanyId();
        final String customerId = enterCustomerId();
        PROJECT_SERVICE.update(Long.valueOf(id), name, Long.valueOf(cost), Long.valueOf(companyId), Long.valueOf(customerId));
        System.out.println(" ✅ You updated \uD83D\uDC49 " + PROJECT_SERVICE.getById(Long.valueOf(id)).get() + "\n");
    }

    private String enterId() {
        System.out.print(" ENTER ID \n\uD83D\uDC49 ");
        String id = scanner.next();
        if (!Validator.validNumber(id) || PROJECT_SERVICE.getById(Long.valueOf(id)).get().getId() == null) {
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
        update();
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
