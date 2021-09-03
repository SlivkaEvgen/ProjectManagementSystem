package org.example.jdbc.config;

import java.io.Closeable;
import java.util.Scanner;

public class ScannerConsole implements Closeable {

  private static Scanner SCANNER;

  public static Scanner getInstance() {
    if (SCANNER == null) {
      synchronized (ScannerConsole.class) {
        if (SCANNER == null) {
          SCANNER = new Scanner(System.in);
        }
      }
    }
    return SCANNER;
  }

  @Override
  public void close() {
    SCANNER.close();
  }
}
