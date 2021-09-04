package org.example.jdbc.service;

import org.example.jdbc.model.Developer;
import org.example.jdbc.repository.interfaces.DeveloperRepository;
import org.example.jdbc.repository.DeveloperRepositoryImpl;
import org.example.jdbc.service.interfaces.DeveloperService;

import java.util.List;
import java.util.Optional;

public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository DEVELOPER_REPOSITORY = new DeveloperRepositoryImpl();

    @Override
    public Optional<Developer> getById(Long id) {
        return DEVELOPER_REPOSITORY.findById(id);
    }

    @Override
    public List<Developer> getAll() {
        return DEVELOPER_REPOSITORY.findAll();
    }

    @Override
    public Developer createNewDeveloper(String name, Long age, String gender, String email, Long numberPhone, Long companyId, Long salary) {
        Developer developer = new Developer();
        developer.setName(name);
        developer.setAge(age);
        developer.setGender(gender);
        developer.setEmail(email);
        developer.setNumberPhone(numberPhone);
        developer.setCompanyId(companyId);
        developer.setSalary(salary);
        return DEVELOPER_REPOSITORY.create(developer);
    }

    @Override
    public void update(Long id, String name, Long age, String gender, String email, Long numberPhone, Long companyId, Long salary) {
        Developer developer = new Developer();
        developer.setSalary(salary);
        developer.setName(name);
        developer.setCompanyId(companyId);
        developer.setEmail(email);
        developer.setAge(age);
        developer.setNumberPhone(numberPhone);
        developer.setGender(gender);
        DEVELOPER_REPOSITORY.update(id, developer);
    }

    @Override
    public void delete(Long id) {
        DEVELOPER_REPOSITORY.delete(id);
    }

    @Override
    public String getSumSalariesDevelopersOfOneProject(Long projectId) {
        return DEVELOPER_REPOSITORY.getSumSalariesDevelopersOfOneProject(projectId);
    }

    @Override
    public List<Developer> getDevelopersFromOneProject(Long projectId) {
        return DEVELOPER_REPOSITORY.getDevelopersFromOneProject(projectId);
    }

    @Override
    public List<Developer> getDevelopersByActivity(String nameActivity) {
        return DEVELOPER_REPOSITORY.getDevelopersByActivity(nameActivity);
    }

    @Override
    public List<Developer> getDevelopersByLevel(String nameLevel) {
        return DEVELOPER_REPOSITORY.getDevelopersByLevel(nameLevel);
    }
}
