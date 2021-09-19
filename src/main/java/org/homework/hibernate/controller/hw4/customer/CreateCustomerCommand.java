package org.homework.hibernate.controller.hw4.customer;

import org.homework.hibernate.config.ScannerConsole;
import org.homework.hibernate.controller.hw4.interfaces.Controller;
import org.homework.hibernate.service.hw4.CustomerServiceImpl;
import org.homework.hibernate.utils.Validator;

import java.util.Scanner;

public class CreateCustomerCommand implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    private void create() {
        final String name = enterName();
        final String budget = enterBudget();
        final String city = enterCity();
//        final String companyId = enterCompanyId();
        new CustomerServiceImpl().createNewCustomer(name,city, Long.valueOf(budget));
        System.out.println(" ✅ You created \uD83D\uDC49 " + "new Customer" + "\n");
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

    private String enterBudget() {
        System.out.print(" ENTER BUDGET \n\uD83D\uDC49 ");
        String budget = scanner.next();
        if (!Validator.validNumber(budget)) {
            System.out.println("Try again");
            return enterBudget();
        }
        return budget;
    }

//    private String enterCompanyId() {
//        System.out.print(" ENTER COMPANY-ID \n\uD83D\uDC49 ");
//        String companyId = scanner.next();
//        try {
//            if (!Validator.validNumber(companyId) | new CompanyServiceImpl().getById(Long.valueOf(companyId)).get().getId() == null) {
//                System.out.println("Try again");
//                return enterCompanyId();
//            }
//        } catch (NumberFormatException r) {
//            System.out.println("Try again");
//            return enterCompanyId();
//        }
//        return companyId;
//    }
private String enterCity() {
    System.out.print(" ENTER CITY \n\uD83D\uDC49 ");
    String city = scanner.next();
        if (!Validator.validString(city) & city.length()>15) {
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
