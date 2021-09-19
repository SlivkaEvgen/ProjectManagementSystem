package org.homework.hibernate.service.hw4.interfaces;

import org.homework.hibernate.model.Company;

public interface CompanyService extends IService<Company, Long> {

    Company createNewCompany(String name, String city);

    void update(Long id, String name, String city);
}
