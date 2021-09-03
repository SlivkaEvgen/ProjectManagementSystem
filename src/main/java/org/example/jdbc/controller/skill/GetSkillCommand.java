package org.example.jdbc.controller.skill;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.utils.Validator;
import org.example.jdbc.service.SkillServiceImpl;
import java.io.Closeable;
import java.util.Scanner;

public class GetSkillCommand implements Closeable {

  private final SkillServiceImpl skillService = new SkillServiceImpl();
  private final Scanner scanner = ScannerConsole.getInstance();

  public void all() {
    System.out.println(skillService.getAll());
  }

  public void byId() {
    System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
    String next = scanner.next();
    getById(next);
  }

  private void getById(String next) {
    if (Validator.validNumber(next)) {
      if (skillService.getById(Long.valueOf(next)).get().getId() != null) {
        System.out.println(skillService.getById(Long.valueOf(next)));
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
