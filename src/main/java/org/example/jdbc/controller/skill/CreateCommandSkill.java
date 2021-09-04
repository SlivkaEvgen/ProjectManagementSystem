package org.example.jdbc.controller.skill;

import org.example.jdbc.config.ScannerConsole;
import org.example.jdbc.utils.Validator;
import org.example.jdbc.controller.interfaces.Controller;
import org.example.jdbc.service.SkillServiceImpl;

import java.util.Scanner;

public class CreateCommandSkill implements Controller {

    private final Scanner scanner = ScannerConsole.getInstance();

    private void create() {
        final String activity = enterActivity();
        final String level = enterLevel();
        new SkillServiceImpl().createNewSkill(activity, level);
        System.out.println(" ✅ You created \uD83D\uDC49 " + "new Skill" + "\n");
    }

    private String enterActivity() {
        System.out.print(" ENTER ACTIVITY \n\uD83D\uDC49 ");
        System.out.println(" Example: Java, C++, JS, C# ");
        String activity = scanner.next();
        if (!Validator.validString(activity) | !activity.equalsIgnoreCase("java")
              & !activity.equalsIgnoreCase("js")
              & !activity.equalsIgnoreCase("c++")
              & !activity.equalsIgnoreCase("c#")) {
            System.out.println("Try again");
            return enterActivity();
        }
        return activity;
    }

    private String enterLevel() {
        System.out.print(" ENTER LEVEL \n\uD83D\uDC49 ");
        System.out.println(" Example: Junior, Middle, Senior");
        final String level = scanner.next();
        if (!Validator.validString(level) | !level.equalsIgnoreCase("junior")
                                            & !level.equalsIgnoreCase("middle")
                                            & !level.equalsIgnoreCase("senior")) {
            System.out.println("Try again");
            return enterLevel();
        }
        return level;
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
