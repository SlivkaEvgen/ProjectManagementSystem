package org.example.jdbc.controller.customer;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.model.Customer;
import org.example.jdbc.service.CustomerServiceImpl;
import org.example.jdbc.utils.Validator;
import java.util.Optional;
import java.util.Scanner;

public class DeleteCustomerCommand extends CustomerCommandImpl {

  private final CustomerServiceImpl customerService = new CustomerServiceImpl();
  private final Scanner scanner = ScannerConsole.getInstance();

  public void delete(String id) {
    if (Validator.validNumber(id)) {
      Optional<Customer> serviceById = customerService.getById(Long.valueOf(id));
      if (serviceById.get().getId() != null) {
        System.out.println("\nAre you sure ?  \n" + serviceById);
        System.out.print("Yes \uD83D\uDC49 Y\nNo  \uD83D\uDC49 N\n\uD83D\uDC49 ");
        String yesNo = scanner.next();
        if (yesNo.equalsIgnoreCase("y")) {
          customerService.delete(Long.valueOf(id));
          System.out.println(" ✅ You removed the Customer number \uD83D\uDC49 " + id + " \n");
        }
      } else {
        System.out.print("\nNot found, try again ... ");
        deleteCommand();
      }
    } else {
      System.out.print("\nNot found, try again ... ");
      deleteCommand();
    }
  }
}
