package org.homework.jdbc.repository.interfaces;

import org.homework.jdbc.model.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<String> getListProjectsWithDate();
}
