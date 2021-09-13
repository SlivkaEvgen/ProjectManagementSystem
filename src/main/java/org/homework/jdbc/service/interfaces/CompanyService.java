package org.homework.jdbc.service.interfaces;

import org.homework.jdbc.model.Company;

public interface CompanyService extends IService<Company, Long> {

    Company createNewCompany(String name, Long totalCost);

    void update(Long id, String name, Long totalCost);
}
