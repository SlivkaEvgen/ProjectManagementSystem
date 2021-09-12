package org.homework.service.interfaces;

import org.homework.model.Project;

import java.util.List;

public interface ProjectService extends IService<Project, Long> {

    Project createNewProject(String name, Long cost, Long companyId, Long customerId);

    void update(Long id, String name, Long cost, Long companyId, Long customerId);

    List<String> getListProjectsWithDate();
}
