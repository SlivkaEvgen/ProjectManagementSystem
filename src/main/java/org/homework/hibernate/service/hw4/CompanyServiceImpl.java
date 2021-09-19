package org.homework.hibernate.service.hw4;

import org.hibernate.Session;
import org.homework.hibernate.model.Company;
import org.homework.hibernate.model.Customer;
import org.homework.hibernate.repository.CrudRepository;
import org.homework.hibernate.repository.RepositoryFactory;
import org.homework.hibernate.service.hw4.interfaces.CompanyService;
import org.homework.hibernate.utils.SessionsOpenClose;

import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements CompanyService {

    private final CrudRepository<Company, Long> CRUD_REPOSITORY = RepositoryFactory.of(Company.class);
private final SessionsOpenClose sessionsOpenClose = SessionsOpenClose.getInstance();
    @Override
    public Optional<Company> getById(Long id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<Company> getAll() {
        return CRUD_REPOSITORY.findAll();
    }

    @Override
    public Company createNewCompany(String name, String city) {
        Company company = new Company();
        company.setName(name);
        company.setCity(city);
        return CRUD_REPOSITORY.save(company);
    }

    @Override
    public void update(Long id, String name, String city) {
        Session session = sessionsOpenClose.createSession();
        session.getTransaction();
        Company company = session.get(Company.class, id);
        company.setName(name);
        company.setCity(city);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.deleteById(id);
    }
}
