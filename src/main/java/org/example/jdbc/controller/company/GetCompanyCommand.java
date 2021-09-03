package org.example.jdbc.controller.company;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.service.CompanyServiceImpl;
import org.example.jdbc.utils.Validator;
import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class GetCompanyCommand implements Closeable {

  private final CompanyServiceImpl companyService = new CompanyServiceImpl();
  private final Scanner scanner = ScannerConsole.getInstance();

  public void all() {
    System.out.println(companyService.getAll());
  }

  public void byId() {
    System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
    String next = scanner.next();
    getById(next);
  }

  private void getById(String next) {
    if (Validator.validNumber(next)) {
      if (companyService.getById(Long.valueOf(next)).get().getId() != null) {
        System.out.println(companyService.getById(Long.valueOf(next)));
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
  public void close() throws IOException {
    System.exit(0);
    scanner.close();
  }
}
