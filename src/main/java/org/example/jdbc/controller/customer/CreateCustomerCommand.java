package org.example.jdbc.controller.customer;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.controller.interfaces.Controller;
import org.example.jdbc.service.CompanyServiceImpl;
import org.example.jdbc.service.CustomerServiceImpl;
import org.example.jdbc.utils.Validator;
import java.util.Scanner;

public class CreateCustomerCommand implements Controller {

  private final CustomerServiceImpl customerService = new CustomerServiceImpl();
  private final Scanner scanner = ScannerConsole.getInstance();

  private void create() {
    String name = enterName();
    String budget = enterBudget();
    String companyId = enterCompanyId();
    customerService.createNewCustomer(name, Long.valueOf(budget), Long.valueOf(companyId));
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

  private String enterCompanyId() {
    System.out.print(" ENTER COMPANY-ID \n\uD83D\uDC49 ");
    String companyId = scanner.next();
    try {
      if (!Validator.validNumber(companyId)
          | new CompanyServiceImpl().getById(Long.valueOf(companyId)).get().getId() == null) {
        System.out.println("Try again");
        return enterCompanyId();
      }
    } catch (NumberFormatException r) {
      System.out.println("Try again");
      return enterCompanyId();
    }
    return companyId;
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
