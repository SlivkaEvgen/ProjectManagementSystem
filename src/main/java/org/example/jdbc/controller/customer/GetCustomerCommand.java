package org.example.jdbc.controller.customer;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.utils.Validator;
import org.example.jdbc.service.CustomerServiceImpl;
import java.io.Closeable;
import java.util.Scanner;

public class GetCustomerCommand implements Closeable {

  private final CustomerServiceImpl customerService = new CustomerServiceImpl();
  private final Scanner scanner = ScannerConsole.getInstance();

  public void all() {
    System.out.println(customerService.getAll());
  }

  public void byId() {
    System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
    String next = scanner.next();
    getById(next);
  }

  private void getById(String next) {
    if (Validator.validNumber(next)) {
      if (customerService.getById(Long.valueOf(next)).get().getId() != null) {
        System.out.println(customerService.getById(Long.valueOf(next)));
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
