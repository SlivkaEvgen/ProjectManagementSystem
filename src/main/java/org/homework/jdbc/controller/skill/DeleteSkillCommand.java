package org.homework.jdbc.controller.skill;

import org.homework.jdbc.config.ScannerConsole;
import org.homework.jdbc.model.Skill;
import org.homework.jdbc.service.SkillServiceImpl;
import org.homework.jdbc.utils.Validator;

import java.util.Optional;
import java.util.Scanner;

public class DeleteSkillCommand extends SkillCommandImpl {

    private final Scanner scanner = ScannerConsole.getInstance();

    public void delete(String id) {
        final SkillServiceImpl skillService = new SkillServiceImpl();
        if (Validator.validNumber(id)) {
            final Optional<Skill> serviceById = skillService.getById(Long.valueOf(id));
            if (serviceById.get().getId() != null) {
                System.out.println("\nAre you sure ?  \n" + serviceById);
                System.out.print("Yes \uD83D\uDC49 Y\nNo  \uD83D\uDC49 N\n\uD83D\uDC49");
                String yesNo = scanner.next();
                if (yesNo.equalsIgnoreCase("y")) {
                    skillService.delete(Long.valueOf(id));
                    System.out.println(" ✅ You removed the Skill number \uD83D\uDC49 " + id + " \n");
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

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
