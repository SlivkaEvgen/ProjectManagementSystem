package org.example.jdbc.controller.interfaces;

import java.sql.SQLIntegrityConstraintViolationException;

public interface Controller {

  void start() throws SQLIntegrityConstraintViolationException;

  void close();
}
