package org.example.jdbc.controller.customer;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.controller.ControllerImpl;
import org.example.jdbc.controller.interfaces.Command;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerCommandImpl implements Command {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String console = scanner.next();
    try {
      if (console.equalsIgnoreCase("GET")) {
        getCommand();
      }
      if (console.equalsIgnoreCase("CREATE")) {
        createCommand();
      }
      if (console.equalsIgnoreCase("UPDATE")) {
        updateCommand();
      }
      if (console.equalsIgnoreCase("DELETE")) {
        deleteCommand();
      }
      if (console.equalsIgnoreCase("BACK")) {
        new ControllerImpl().start();
      }
      if (console.equalsIgnoreCase("STOP")) {
        close();
      } else {
        System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
        start();
      }
    } catch (InputMismatchException s) {
      System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
      new CustomerCommandImpl().start();
    }
  }

  @Override
  public void getCommand() {
    GetCustomerCommand getCustomerCommand = new GetCustomerCommand();
    System.out.print(
        "\n \uD83D\uDC49 ByID\n \uD83D\uDC49 All\n   \uD83D\uDC49 BACK\n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String console = scanner.next();
    if (console.equalsIgnoreCase("ByID")) {
      getCustomerCommand.byId();
      getCommand();
    }
    if (console.equalsIgnoreCase("ALL")) {
      getCustomerCommand.all();
      getCommand();
    }
    if (console.equalsIgnoreCase("BACK")) {
      start();
    }
    if (console.equalsIgnoreCase("STOP")) {
      close();
    } else {
      System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
      getCommand();
    }
    getCommand();
  }

  @Override
  public void createCommand() {
    new CreateCustomerCommand().start();
    start();
  }

  @Override
  public void updateCommand() {
    new UpdateCustomerCommand().start();
    start();
  }

  @Override
  public void deleteCommand() {
    System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
    String id = scanner.next();
    new DeleteCustomerCommand().delete(id);
    start();
  }

  @Override
  public void close() {
    System.exit(0);
    scanner.close();
  }
}
