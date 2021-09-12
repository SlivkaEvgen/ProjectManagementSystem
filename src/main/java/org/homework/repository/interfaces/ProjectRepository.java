package org.homework.repository.interfaces;

import org.homework.model.Project;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<String> getListProjectsWithDate();
}
