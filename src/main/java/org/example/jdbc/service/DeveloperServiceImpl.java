package org.example.jdbc.service;

import org.example.jdbc.model.Developer;
import org.example.jdbc.repository.interfaces.DeveloperRepository;
import org.example.jdbc.repository.DeveloperRepositoryImpl;
import org.example.jdbc.service.interfaces.DeveloperService;
import java.util.List;
import java.util.Optional;

public class DeveloperServiceImpl implements DeveloperService {

  private final DeveloperRepository developerRepository = new DeveloperRepositoryImpl();

  @Override
  public Optional<Developer> getById(Long id) {
    return developerRepository.findById(id);
  }

  @Override
  public List<Developer> getAll() {
    return developerRepository.findAll();
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
    developerRepository.create(developer);
    return developer;
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
    developerRepository.update(id, developer);
  }

  @Override
  public void delete(Long id) {
    developerRepository.delete(id);
  }

  @Override
  public String getSumSalariesDevelopersOfOneProject(Long projectId) {
    return developerRepository.getSumSalariesDevelopersOfOneProject(projectId);
  }

  @Override
  public List<Developer> getDevelopersFromOneProject(Long projectId) {
    return developerRepository.getDevelopersFromOneProject(projectId);
  }

  @Override
  public List<Developer> getDevelopersByActivity(String nameActivity) {
    return developerRepository.getDevelopersByActivity(nameActivity);
  }

  @Override
  public List<Developer> getDevelopersByLevel(String nameLevel) {
    return developerRepository.getDevelopersByLevel(nameLevel);
  }
}
