package org.homework.controller.skill;

import org.homework.config.ScannerConsole;
import org.homework.service.SkillServiceImpl;
import org.homework.utils.Validator;

import java.io.Closeable;
import java.util.Scanner;

public class GetSkillCommand implements Closeable {

    private final SkillServiceImpl SKILL_SERVICE = new SkillServiceImpl();
    private final Scanner scanner = ScannerConsole.getInstance();

    public void all() {
        System.out.println(SKILL_SERVICE.getAll());
    }

    public void byId() {
        System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
        getById(scanner.next());
    }

    private void getById(String next) {
        if (Validator.validNumber(next)) {
            if (SKILL_SERVICE.getById(Long.valueOf(next)).get().getId() != null) {
                System.out.println(SKILL_SERVICE.getById(Long.valueOf(next)));
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
