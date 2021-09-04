package org.example.jdbc.service.interfaces;

import org.example.jdbc.model.Developer;

import java.util.List;

public interface DeveloperService extends IService<Developer, Long> {

    Developer createNewDeveloper(String name, Long age, String gender, String email, Long numberPhone, Long companyId, Long salary);

    void update(Long id, String name, Long age, String gender, String email, Long numberPhone, Long companyId, Long salary);

    String getSumSalariesDevelopersOfOneProject(Long projectId);

    List<Developer> getDevelopersFromOneProject(Long projectId);

    List<Developer> getDevelopersByActivity(String nameActivity);

    List<Developer> getDevelopersByLevel(String nameLevel);
}
