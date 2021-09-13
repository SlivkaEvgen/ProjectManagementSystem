package org.homework.jdbc.repository;

import org.homework.jdbc.config.DatabaseConnection;
import org.homework.jdbc.model.Company;
import lombok.SneakyThrows;
import org.homework.jdbc.repository.interfaces.CrudRepository;
import org.homework.jdbc.utils.PropertiesLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyRepositoryImpl implements CrudRepository<Company, Long> {

    private final Connection CONNECTION = DatabaseConnection.getInstance().getConnection();
    private final String SCHEMA_NAME = PropertiesLoader.getProperties("db.schemaName");

    @SneakyThrows
    @Override
    public List<Company> findAll() {
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT*FROM companies");
        final List<Company> companyList = new ArrayList<>();
        while (resultSet.next()) {
            final Company company = Company.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .totalCostOfProjects(resultSet.getLong("total_cost_projects"))
                    .build();
            companyList.add(company);
        }
        return companyList;
    }

    @SneakyThrows
    @Override
    public Optional<Company> findById(Long id) {
        Company company = new Company();
        final ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM companies WHERE id=" + id + ";");
        while (resultSet.next()) {
            company = Company.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .totalCostOfProjects(resultSet.getLong("total_cost_projects"))
                    .build();
        }
        return Optional.ofNullable(company);
    }

    @SneakyThrows
    @Override
    public Company create(Company company) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO " + SCHEMA_NAME + ".companies (name,total_cost_projects) VALUES (?,?) ;");
        preparedStatement.setString(1, company.getName());
        preparedStatement.setLong(2, company.getTotalCostOfProjects());
        preparedStatement.executeUpdate();
        return company;
    }

    @SneakyThrows
    @Override
    public Company update(Long id, Company company) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE  " + SCHEMA_NAME + ".companies SET name=?,total_cost_projects=?  WHERE id=" + id + ";");
        preparedStatement.setString(1, company.getName());
        preparedStatement.setLong(2, company.getTotalCostOfProjects());
        preparedStatement.execute();
        return company;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
        CONNECTION
                .createStatement()
                .execute("DELETE FROM  " + SCHEMA_NAME + ".companies  WHERE id=" + id);
    }
}
