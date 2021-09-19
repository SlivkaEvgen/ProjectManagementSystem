package org.homework.hibernate.service.hw4.interfaces;

import org.homework.hibernate.model.Customer;

public interface CustomerService extends IService<Customer, Long> {

    Customer createNewCustomer(String name,String city, Long budget);

    void update(Long id, String name,String city, Long budget);
}
