package org.example.jdbc.controller.project;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.utils.Validator;
import org.example.jdbc.model.Project;
import org.example.jdbc.service.ProjectServiceImpl;
import java.util.Optional;
import java.util.Scanner;

public class DeleteProjectCommand extends ProjectCommandImpl {

  private final ProjectServiceImpl projectService = new ProjectServiceImpl();
  private final Scanner scanner = ScannerConsole.getInstance();

  public void delete(String id) {
    if (Validator.validNumber(id)) {
      Optional<Project> serviceById = projectService.getById(Long.valueOf(id));
      if (serviceById.get().getId() != null) {
        System.out.println("\nAre you sure ?  \n" + serviceById);
        System.out.print("Yes \uD83D\uDC49 Y\nNo  \uD83D\uDC49 N\n\uD83D\uDC49");
        String yesNo = scanner.next();
        if (yesNo.equalsIgnoreCase("y")) {
          projectService.delete(Long.valueOf(id));
          System.out.println(" ✅ You removed the Project number \uD83D\uDC49 " + id + " \n");
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
