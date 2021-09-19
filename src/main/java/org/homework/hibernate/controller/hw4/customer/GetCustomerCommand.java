package org.homework.hibernate.controller.hw4.customer;

import org.homework.hibernate.config.ScannerConsole;
import org.homework.hibernate.service.hw4.CustomerServiceImpl;
import org.homework.hibernate.utils.Validator;

import java.io.Closeable;
import java.util.Scanner;

public class GetCustomerCommand implements Closeable {

    private final CustomerServiceImpl CUSTOMER_SERVICE = new CustomerServiceImpl();
    private final Scanner scanner = ScannerConsole.getInstance();

    public void all() {
        System.out.println(CUSTOMER_SERVICE.getAll());
    }

    public void byId() {
        System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
        getById(scanner.next());
    }

    private void getById(String next) {
        if (Validator.validNumber(next)) {
            if (CUSTOMER_SERVICE.getById(Long.valueOf(next)).get().getId() != null) {
                System.out.println(CUSTOMER_SERVICE.getById(Long.valueOf(next)));
            } else {
                System.out.print("\nNot found, try again ... ");
                byId();
            }
        } else {
            System.out.print("\nNot found, try again ... ");
            byId();
        }
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
