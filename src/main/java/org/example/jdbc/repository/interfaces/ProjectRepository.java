package org.example.jdbc.repository.interfaces;

import org.example.jdbc.model.Project;
import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<String> getListProjectsWithDate();
}
