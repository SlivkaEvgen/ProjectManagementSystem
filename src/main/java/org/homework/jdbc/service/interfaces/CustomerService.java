package org.homework.jdbc.service.interfaces;

import org.homework.jdbc.model.Customer;

public interface CustomerService extends IService<Customer, Long> {

    Customer createNewCustomer(String name, Long budget, Long companyId);

    void update(Long id, String name, Long budget, Long companyId);
}
