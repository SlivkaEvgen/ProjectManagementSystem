package org.homework.hibernate.service.hw4.interfaces;

import org.homework.hibernate.model.Project;

import java.util.List;

public interface ProjectService extends IService<Project, Long> {

    Project createNewProject(String name, Long cost,Long companyId, Long customerId);

    void update(Long id, String name, Long cost);

    List<String> getListProjectsWithDate();
}
