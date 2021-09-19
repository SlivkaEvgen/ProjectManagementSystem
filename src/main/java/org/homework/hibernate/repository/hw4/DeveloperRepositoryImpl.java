//package org.homework.hibernate.repository;
//
//import org.homework.hibernate.model.Developer;
//import lombok.SneakyThrows;
//import org.homework.hibernate.repository.hw4.interfaces.DeveloperRepository;
//import org.homework.hibernate.utils.PropertiesLoader;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class DeveloperRepositoryImpl implements DeveloperRepository {
//
//    private final Connection CONNECTION = null;//DatabaseConnection.getInstance().getConnection();
//    private final String SCHEMA_NAME = PropertiesLoader.getProperties("db.schemaName");
//
//    @SneakyThrows
//    @Override
//    public Optional<Developer> findById(Long id) {
//        Developer developer = new Developer();
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers WHERE id=" + id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            developer = Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .age(resultSet.getLong("age"))
//                    .gender(resultSet.getString("gender"))
//                    .email(resultSet.getString("email"))
//                    .numberPhone(resultSet.getLong("number_phone"))
//                    //.companyId(resultSet.getLong("company_id"))
//                    .salary(resultSet.getLong("salary"))
//                    .build();
//        }
//        return Optional.ofNullable(developer);
//    }
//
//    @SneakyThrows
//    @Override
//    public List<Developer> findAll() {
//        final List<Developer> developersList = new ArrayList<>();
//        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM developers");
//        while (resultSet.next()) {
//            final Developer developer = Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .age(resultSet.getLong("age"))
//                    .gender(resultSet.getString("gender"))
//                    .email(resultSet.getString("email"))
//                    .numberPhone(resultSet.getLong("number_phone"))
//                   // .companyId(resultSet.getLong("company_id"))
//                    .salary(resultSet.getLong("salary"))
//                    .build();
//            developersList.add(developer);
//        }
//        return developersList;
//    }
//
//    @SneakyThrows
//    @Override
//    public Developer create(Developer developer) {
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO " + SCHEMA_NAME + ".developers (name,age,gender,email,number_phone,salary)" + " VALUES (?,?,?,?,?,?)");
//        preparedStatement.setString(1, developer.getName());
//        preparedStatement.setLong(2, developer.getAge());
//        preparedStatement.setString(3, developer.getGender());
//        preparedStatement.setString(4, developer.getEmail());
//        preparedStatement.setLong(5, developer.getNumberPhone());
//       // preparedStatement.setLong(6, developer.getCompanyId());
//        preparedStatement.setLong(6, developer.getSalary());
//        preparedStatement.executeUpdate();
//        return developer;
//    }
//
//    @SneakyThrows
//    @Override
//    public Developer update(Long id, Developer developer) {
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE " + SCHEMA_NAME + ".developers set name=?, age=?, gender=?, email=?,number_phone =?, salary=? WHERE id=" + id + ";");
//        preparedStatement.setString(1, developer.getName());
//        preparedStatement.setLong(2, developer.getAge());
//        preparedStatement.setString(3, developer.getGender());
//        preparedStatement.setString(4, developer.getEmail());
//        preparedStatement.setLong(5, developer.getNumberPhone());
//       // preparedStatement.setLong(6, developer.getCompanyId());
//        preparedStatement.setLong(6, developer.getSalary());
//        preparedStatement.execute();
//        return developer;
//    }
//
//    @SneakyThrows
//    @Override
//    public void delete(Long id) {
//        CONNECTION.prepareStatement("DELETE FROM " + SCHEMA_NAME + ".developers WHERE id=" + id).executeUpdate();
//    }
//
//    @SneakyThrows
//    @Override
//    public String getSumSalariesDevelopersOfOneProject(Long projectId) {
//        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT projects.id AS projectID, projects.name AS projectName, "
//                                                                        + "SUM(developers.salary) AS sumSalaries "
//                                                                        + "FROM developers_projects "
//                                                                        + "inner join developers on developers_projects.developer_id = developers.id "
//                                                                        + "inner join projects on developers_projects.project_id = projects.id "
//                                                                        + "GROUP BY projects.id");
//        List<String> totalSalaries = new ArrayList<>();
//        while (resultSet.next()) {
//            totalSalaries.add((int) resultSet.getLong("projectID") - 1, (resultSet.getString("projectName") + " = " + resultSet.getString("sumSalaries")));
//        }
//        return totalSalaries.get(Math.toIntExact(projectId) - 1);
//    }
//
//    @SneakyThrows
//    @Override
//    public List<Developer> getDevelopersFromOneProject(Long projectId) {
//        List<Developer> developersList = new ArrayList<>();
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers_projects "
//                                                                          + "inner join " + SCHEMA_NAME + ".developers on " + SCHEMA_NAME + ".developers_projects.developer_id = " + SCHEMA_NAME + ".developers.id "
//                                                                          + "inner join " + SCHEMA_NAME + ".projects on " + SCHEMA_NAME + ".developers_projects.project_id = " + SCHEMA_NAME + ".projects.id "
//                                                                          + "WHERE " + SCHEMA_NAME + ".projects.id=?");
//        preparedStatement.setLong(1, projectId);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            Developer developer = Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .age(resultSet.getLong("age"))
//                    .gender(resultSet.getString("gender"))
//                    .email(resultSet.getString("email"))
//                    .numberPhone(resultSet.getLong("number_phone"))
//                   // .companyId(resultSet.getLong("company_id"))
//                    .salary(resultSet.getLong("salary"))
//                    .build();
//            developersList.add(developer);
//        }
//        return developersList;
//    }
//
//    @SneakyThrows
//    @Override
//    public List<Developer> getDevelopersByActivity(String nameActivity) {
//        final List<Developer> developersList = new ArrayList<>();
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers_skills "
//                                                                          + "inner join " + SCHEMA_NAME + ".developers on " + SCHEMA_NAME + ".developers_skills.developer_id = " + SCHEMA_NAME + ".developers.id "
//                                                                          + "inner join " + SCHEMA_NAME + ".skills on " + SCHEMA_NAME + ".developers_skills.skills_id = " + SCHEMA_NAME + ".skills.id "
//                                                                          + "WHERE " + SCHEMA_NAME + ".skills.activities=?");
//        preparedStatement.setString(1, nameActivity);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            final Developer developer = Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .age(resultSet.getLong("age"))
//                    .gender(resultSet.getString("gender"))
//                    .email(resultSet.getString("email"))
//                    .numberPhone(resultSet.getLong("number_phone"))
//                   // .companyId(resultSet.getLong("company_id"))
//                    .salary(resultSet.getLong("salary"))
//                    .build();
//            developersList.add(developer);
//        }
//        return developersList;
//    }
//
//    @SneakyThrows
//    @Override
//    public List<Developer> getDevelopersByLevel(String nameLevel) {
//        final List<Developer> developersList = new ArrayList<>();
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("SELECT * FROM " + SCHEMA_NAME + ".developers_skills "
//                                                                          + "inner join " + SCHEMA_NAME + ".developers on " + SCHEMA_NAME + ".developers_skills.developer_id = " + SCHEMA_NAME + ".developers.id "
//                                                                          + "inner join " + SCHEMA_NAME + ".skills on " + SCHEMA_NAME + ".developers_skills.skills_id = " + SCHEMA_NAME + ".skills.id "
//                                                                          + "WHERE " + SCHEMA_NAME + ".skills.level=?");
//        preparedStatement.setString(1, nameLevel);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        while (resultSet.next()) {
//            final Developer developer = Developer.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .age(resultSet.getLong("age"))
//                    .gender(resultSet.getString("gender"))
//                    .email(resultSet.getString("email"))
//                    .numberPhone(resultSet.getLong("number_phone"))
//                   // .companyId(resultSet.getLong("company_id"))
//                    .salary(resultSet.getLong("salary"))
//                    .build();
//            developersList.add(developer);
//        }
//        return developersList;
//    }
//}
