package org.example.jdbc.controller.developer;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.controller.ControllerImpl;
import org.example.jdbc.controller.interfaces.Command;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeveloperCommandImpl implements Command {

  private final Scanner scanner = ScannerConsole.getInstance();

  @Override
  public void start() {
    System.out.print(
        "\n \uD83D\uDC49 GET\n \uD83D\uDC49 CREATE\n \uD83D\uDC49 UPDATE\n \uD83D\uDC49 DELETE \n   \uD83D\uDC49 BACK \n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String console = this.scanner.next();
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
    } catch (NoSuchElementException s) {
      System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n");
      new DeveloperCommandImpl().start();
    }
  }

  @Override
  public void getCommand() {
    GetDeveloperCommand getDeveloperCommand = new GetDeveloperCommand();
    System.out.print(
        "\n \uD83D\uDC49 ByID\n \uD83D\uDC49 All\n \uD83D\uDC49 ByProjectID\n \uD83D\uDC49 ByActivity\n \uD83D\uDC49 ByLevel\n \uD83D\uDC49 SumSalaries\n   \uD83D\uDC49 BACK\n   \uD83D\uDC49 STOP\n\uD83D\uDC49 ");
    String console = scanner.next();
    if (console.equalsIgnoreCase("ByID")) {
      getDeveloperCommand.byId();
      getCommand();
    }
    if (console.equalsIgnoreCase("ALL")) {
      getDeveloperCommand.all();
      getCommand();
    }
    if (console.equalsIgnoreCase("ByProjectID")) {
      getDeveloperCommand.getByProjectID();
      getCommand();
    }
    if (console.equalsIgnoreCase("ByActivity")) {
      getDeveloperCommand.getByActivity();
      getCommand();
    }
    if (console.equalsIgnoreCase("ByLevel")) {
      getDeveloperCommand.getByLevel();
      getCommand();
    }
    if (console.equalsIgnoreCase("SumSalaries")) {
      getDeveloperCommand.getSumSalaries();
      getCommand();
    }
    if (console.equalsIgnoreCase("BACK")) {
      start();
    }
    if (console.equalsIgnoreCase("STOP")) {
      close();
    } else {
      System.out.print("        ⛔WRONG⛔\n\uD83D\uDCACPlease, enter again \n\n");
      getCommand();
    }
    getCommand();
  }

  @Override
  public void createCommand() {
    new CreateDeveloperCommand().start();
    start();
  }

  @Override
  public void updateCommand() {
    new UpdateDeveloperCommand().start();
    start();
  }

  @Override
  public void deleteCommand() {
    System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
    String id = scanner.next();
    new DeleteDeveloperCommand().delete(id);
    start();
  }

  @Override
  public void close() {
    System.exit(0);
    scanner.close();
  }
}
