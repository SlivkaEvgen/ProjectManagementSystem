package org.homework.hibernate.service.hw4.interfaces;

import org.homework.hibernate.model.Developer;

import java.util.List;

public interface DeveloperService extends IService<Developer, Long> {

    Developer createNewDeveloper(String name, Long age, String gender, String email, Long salary,Long companyId);

    void update(Long id, String name, Long age, String gender, String email, Long salary,Long companyId);

    Long getSumSalariesDevelopersOfOneProject(Long projectId);

    List<Developer> getDevelopersFromOneProject(Long projectId);

    List<Developer> getDevelopersByActivity(String nameActivity);

    List<Developer> getDevelopersByLevel(String nameLevel);
}
