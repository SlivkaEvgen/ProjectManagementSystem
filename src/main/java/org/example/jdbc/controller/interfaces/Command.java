package org.example.jdbc.controller.interfaces;

import java.sql.SQLIntegrityConstraintViolationException;

public interface Command extends Controller {

  void getCommand();

  void createCommand() throws SQLIntegrityConstraintViolationException;

  void updateCommand() throws SQLIntegrityConstraintViolationException;

  void deleteCommand();
}
