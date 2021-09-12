package org.homework.controller.project;

import org.homework.config.ScannerConsole;
import org.homework.model.Project;
import org.homework.service.ProjectServiceImpl;
import org.homework.utils.Validator;

import java.util.Optional;
import java.util.Scanner;

public class DeleteProjectCommand extends ProjectCommandImpl {

    private final Scanner scanner = ScannerConsole.getInstance();

    public void delete(String id) {
        final ProjectServiceImpl projectService = new ProjectServiceImpl();
        if (Validator.validNumber(id)) {
            final Optional<Project> serviceById = projectService.getById(Long.valueOf(id));
            if (serviceById.get().getId() != null) {
                System.out.println("\nAre you sure ?  \n" + serviceById);
                System.out.print("Yes \uD83D\uDC49 Y\nNo  \uD83D\uDC49 N\n\uD83D\uDC49");
                final String yesNo = scanner.next();
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
