package org.homework.jdbc.controller.developer;

import org.homework.jdbc.config.ScannerConsole;
import org.homework.jdbc.service.DeveloperServiceImpl;
import org.homework.jdbc.utils.Validator;

import java.io.Closeable;
import java.util.Scanner;

public class GetDeveloperCommand implements Closeable {

    private final DeveloperServiceImpl DEVELOPER_SERVICE = new DeveloperServiceImpl();
    private final Scanner scanner = ScannerConsole.getInstance();

    public void all() {
        System.out.println(DEVELOPER_SERVICE.getAll());
    }

    public void byId() {
        System.out.print("\n ENTER ID \n\uD83D\uDC49 ");
        getById(scanner.next());
    }

    private void getById(String next) {
        if (Validator.validNumber(next)) {
            if (DEVELOPER_SERVICE.getById(Long.valueOf(next)).get().getId() != null) {
                System.out.println(DEVELOPER_SERVICE.getById(Long.valueOf(next)));
            } else {
                System.out.print("\nNot found, try again ... ");
                byId();
            }
        } else {
            System.out.print("\nNot found, try again ... ");
            byId();
        }
    }

    public void getByProjectID() {
        System.out.print(" ENTER PROJECT-ID \n\uD83D\uDC49 ");
        String next = scanner.next();
        if (Validator.validNumber(next)) {
            if (!DEVELOPER_SERVICE.getDevelopersFromOneProject(Long.valueOf(next)).isEmpty()) {
                System.out.println(DEVELOPER_SERVICE.getDevelopersFromOneProject(Long.valueOf(next)) + "\n");
            } else {
                System.out.println("not found, try again ");
                getByProjectID();
            }
        } else {
            System.out.println("not found, try again ");
            getByProjectID();
        }
    }

    public void getByActivity() {
        System.out.print(" ENTER ACTIVITY \n ✅examples : Java, JS, C++, C# \n\uD83D\uDC49 ");
        String activity = scanner.next();
        if (Validator.validString(activity)) {
            if (!activity.equalsIgnoreCase("js")) {
                if (!activity.equalsIgnoreCase("java")) {
                    if (!activity.equalsIgnoreCase("C++")) {
                        if (!activity.equalsIgnoreCase("C#")) {
                            System.out.println("not found, try again ");
                            getByActivity();
                        } else {
                            System.out.println(DEVELOPER_SERVICE.getDevelopersByActivity(activity) + "\n");
                        }
                    } else {
                        System.out.println(DEVELOPER_SERVICE.getDevelopersByActivity(activity) + "\n");
                    }
                } else {
                    System.out.println(DEVELOPER_SERVICE.getDevelopersByActivity(activity) + "\n");
                }
            } else {
                System.out.println(DEVELOPER_SERVICE.getDevelopersByActivity(activity) + "\n");
            }
        } else {
            System.out.println("not found, try again ");
            getByActivity();
        }
    }

    public void getByLevel() {
        System.out.print(" ENTER LEVEL \n ✅examples : Junior, Middle, Senior \n\uD83D\uDC49 ");
        String level = scanner.next();
        if (Validator.validString(level)) {
            if (!level.equalsIgnoreCase("middle")) {
                if (!level.equalsIgnoreCase("senior")) {
                    if (!level.equalsIgnoreCase("junior")) {
                        System.out.println("not found, try again ");
                        getByLevel();
                    } else {
                        System.out.println(DEVELOPER_SERVICE.getDevelopersByLevel(level) + "\n");
                    }
                } else {
                    System.out.println(DEVELOPER_SERVICE.getDevelopersByLevel(level) + "\n");
                }
            } else {
                System.out.println(DEVELOPER_SERVICE.getDevelopersByLevel(level) + "\n");
            }
        } else {
            System.out.print("\n not found, try again \n");
            getByLevel();
        }
    }

    public void getSumSalaries() {
        System.out.print(" ENTER PROJECT-ID \n\uD83D\uDC49 ");
        String next = scanner.next();
        if (Validator.validNumber(next)) {
            try {
                if (!next.isEmpty()) {
                    long nextLong = Long.parseLong(next);
                    if (nextLong != 0) {
                        System.out.print(DEVELOPER_SERVICE.getSumSalariesDevelopersOfOneProject(nextLong) + "\n");
                    } else {
                        System.out.print("\nnot found, try again \n");
                        getSumSalaries();
                    }
                } else {
                    System.out.print("\nnot found, try again \n");
                    getSumSalaries();
                }
            } catch (IndexOutOfBoundsException t) {
                System.out.print("\nnot found, try again \n");
                getSumSalaries();
            }
        } else {
            System.out.print("\nnot found, try again \n");
            getSumSalaries();
        }
    }

    @Override
    public void close() {
        System.exit(0);
        scanner.close();
    }
}
