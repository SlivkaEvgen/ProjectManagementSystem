package org.example.jdbc.service;

import org.example.jdbc.model.Company;
import org.example.jdbc.repository.CompanyRepositoryImpl;
import org.example.jdbc.repository.interfaces.CrudRepository;
import org.example.jdbc.service.interfaces.CompanyService;
import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {

  private final CrudRepository<Company, Long> crudRepository = new CompanyRepositoryImpl();

  @Override
  public Optional<Company> getById(Long id) {
    return crudRepository.findById(id);
  }

  @Override
  public List<Company> getAll() {
    return crudRepository.findAll();
  }

  @Override
  public Company createNewCompany(String name, Long totalCost) {
    Company company = new Company();
    company.setName(name);
    company.setTotalCostOfProjects(totalCost);
    crudRepository.create(company);
    return company;
  }

  @Override
  public void update(Long id, String name, Long totalCost) {
    Company company = new Company();
    company.setName(name);
    company.setTotalCostOfProjects(totalCost);
    crudRepository.update(id, company);
  }

  @Override
  public void delete(Long id) {
    crudRepository.delete(id);
  }
}
