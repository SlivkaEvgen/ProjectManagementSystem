package org.homework.service.interfaces;

import org.homework.model.Company;

public interface CompanyService extends IService<Company, Long> {

    Company createNewCompany(String name, Long totalCost);

    void update(Long id, String name, Long totalCost);
}
