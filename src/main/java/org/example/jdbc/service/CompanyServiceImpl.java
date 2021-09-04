package org.example.jdbc.service;

import org.example.jdbc.model.Company;
import org.example.jdbc.repository.CompanyRepositoryImpl;
import org.example.jdbc.repository.interfaces.CrudRepository;
import org.example.jdbc.service.interfaces.CompanyService;

import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {

    private final CrudRepository<Company, Long> CRUD_REPOSITORY = new CompanyRepositoryImpl();

    @Override
    public Optional<Company> getById(Long id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<Company> getAll() {
        return CRUD_REPOSITORY.findAll();
    }

    @Override
    public Company createNewCompany(String name, Long totalCost) {
        Company company = new Company();
        company.setName(name);
        company.setTotalCostOfProjects(totalCost);
        return CRUD_REPOSITORY.create(company);
    }

    @Override
    public void update(Long id, String name, Long totalCost) {
        Company company = new Company();
        company.setName(name);
        company.setTotalCostOfProjects(totalCost);
        CRUD_REPOSITORY.update(id, company);
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.delete(id);
    }
}
