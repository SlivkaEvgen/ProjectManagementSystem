package org.homework.hibernate.service.hw4;

import org.hibernate.Session;
import org.homework.hibernate.model.Customer;
import org.homework.hibernate.model.Project;
import org.homework.hibernate.repository.CrudRepository;
import org.homework.hibernate.repository.RepositoryFactory;
import org.homework.hibernate.service.hw4.interfaces.CustomerService;
import org.homework.hibernate.utils.SessionsOpenClose;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CrudRepository<Customer, Long> CRUD_REPOSITORY = RepositoryFactory.of(Customer.class);
private  final SessionsOpenClose sessionsOpenClose = SessionsOpenClose.getInstance();
    @Override
    public Optional<Customer> getById(Long id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<Customer> getAll() {
        return CRUD_REPOSITORY.findAll();
    }

    @Override
    public void update(Long id, String name, String city, Long budget) {
        Session session = sessionsOpenClose.createSession();
        session.getTransaction();
        Customer customer = session.get(Customer.class, id);
        customer.setName(name);
        customer.setCity(city);
        customer.setBudget(budget);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.deleteById(id);
    }

    @Override
    public Customer createNewCustomer(String name, String city, Long budget) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCity(city);
        customer.setBudget(budget);
        return CRUD_REPOSITORY.save(customer);
    }
}
