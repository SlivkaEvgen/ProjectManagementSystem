package org.example.jdbc.repository;

import lombok.SneakyThrows;
import org.example.jdbc.config.DatabaseConnection;
import org.example.jdbc.model.Customer;
import org.example.jdbc.repository.interfaces.CrudRepository;
import org.example.jdbc.utils.PropertiesLoader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CrudRepository<Customer, Long> {

    private final Connection CONNECTION = DatabaseConnection.getInstance().getConnection();
    private final String SCHEMA_NAME = PropertiesLoader.getProperties("db.schemaName");

    @SneakyThrows
    @Override
    public List<Customer> findAll() {
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT*FROM customers");
        final List<Customer> customerList = new ArrayList<>();
        while (resultSet.next()) {
            final Customer customer = Customer.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .budget(resultSet.getLong("budget"))
                    .companyId(resultSet.getLong("company_id"))
                    .build();
            customerList.add(customer);
        }
        return customerList;
    }

    @SneakyThrows
    @Override
    public Optional<Customer> findById(Long id) {
        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM customers WHERE id=" + id + ";");
        Customer customer = new Customer();
        while (resultSet.next()) {
            customer = Customer.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .budget(resultSet.getLong("budget"))
                    .companyId(resultSet.getLong("company_id"))
                    .build();
        }
        return Optional.ofNullable(customer);
    }

    @SneakyThrows
    @Override
    public Customer create(Customer customer) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO " + SCHEMA_NAME + ".customers (name,budget,company_id)" + " VALUES (?,?,?)");
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setLong(2, customer.getBudget());
        preparedStatement.setLong(3, customer.getCompanyId());
        preparedStatement.executeUpdate();
        return customer;
    }

    @SneakyThrows
    @Override
    public Customer update(Long id, Customer customer) {
        PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE " + SCHEMA_NAME + ".customers set name=?,budget=?,company_id=?  WHERE id=" + id + ";");
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setLong(2, customer.getBudget());
        preparedStatement.setLong(3, customer.getCompanyId());
        preparedStatement.execute();
        return customer;
    }

    @SneakyThrows
    @Override
    public void delete(Long id) {
        CONNECTION.createStatement().execute("DELETE FROM " + SCHEMA_NAME + ".customers WHERE id=" + id);
    }
}
