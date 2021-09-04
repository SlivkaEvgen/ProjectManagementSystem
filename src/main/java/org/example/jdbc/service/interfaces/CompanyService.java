package org.example.jdbc.service.interfaces;

import org.example.jdbc.model.Company;

public interface CompanyService extends IService<Company, Long> {

    Company createNewCompany(String name, Long totalCost);

    void update(Long id, String name, Long totalCost);
}
