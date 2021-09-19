//package org.homework.hibernate.repository;
//
//import org.homework.hibernate.model.Project;
//import lombok.SneakyThrows;
//import org.homework.hibernate.repository.hw4.interfaces.ProjectRepository;
//import org.homework.hibernate.utils.PropertiesLoader;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ProjectRepositoryImpl implements ProjectRepository {
//
//    private final Connection CONNECTION = null;//DatabaseConnection.getInstance().getConnection();
//    private final String SCHEMA_NAME = PropertiesLoader.getProperties("db.schemaName");
//
//    @SneakyThrows
//    @Override
//    public Optional<Project> findById(Long id) {
//        Project project = new Project();
//        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM projects WHERE id=" + id + ";");
//        while (resultSet.next()) {
//            project = Project.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .cost(resultSet.getLong("cost"))
//                  //  .companyId(resultSet.getLong("company_id"))
//                  //  .customerId(resultSet.getLong("customer_id"))
//                    .firstDate(resultSet.getString("first_date"))
//                    .build();
//        }
//        return Optional.ofNullable(project);
//    }
//
//    @SneakyThrows
//    @Override
//    public List<Project> findAll() {
//        final List<Project> projectList = new ArrayList<>();
//        ResultSet resultSet = CONNECTION.createStatement().executeQuery("SELECT * FROM projects");
//        while (resultSet.next()) {
//            final Project project = Project.builder()
//                    .id(resultSet.getLong("id"))
//                    .name(resultSet.getString("name"))
//                    .cost(resultSet.getLong("cost"))
//                   // .companyId(resultSet.getLong("company_id"))
//                   // .customerId(resultSet.getLong("customer_id"))
//                    .firstDate(resultSet.getString("first_date"))
//                    .build();
//            projectList.add(project);
//        }
//        return projectList;
//    }
//
//    @SneakyThrows
//    @Override
//    public Project create(Project project) {
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("INSERT INTO " + SCHEMA_NAME + ".projects (name,cost)" + " VALUES (?,?)");
//        preparedStatement.setString(1, project.getName());
//        preparedStatement.setLong(2, project.getCost());
//     //   preparedStatement.setLong(3, project.getCompanyId());
//      //  preparedStatement.setLong(4, project.getCustomerId());
//       // preparedStatement.setString(3, project.getFirstDate());
//        preparedStatement.executeUpdate();
//        return project;
//    }
//
//    @SneakyThrows
//    @Override
//    public Project update(Long id, Project project) {
//        PreparedStatement preparedStatement = CONNECTION.prepareStatement("UPDATE " + SCHEMA_NAME + ".projects set name=?,cost=?  WHERE id=" + id + ";");
//        preparedStatement.setString(1, project.getName());
//        preparedStatement.setLong(2, project.getCost());
//       // preparedStatement.setLong(3, project.getCompanyId());
//       // preparedStatement.setLong(4, project.getCustomerId());
//        //preparedStatement.setString(3, project.getFirstDate());
//        preparedStatement.execute();
//        return project;
//    }
//
//    @SneakyThrows
//    @Override
//    public void delete(Long id) {
//        CONNECTION.createStatement().execute("DELETE FROM " + SCHEMA_NAME + ".projects WHERE id=" + id);
//    }
//
//    @Override
//    public List<String> getListProjectsWithDate() {
//        List<Project> projectList = new ProjectRepositoryImpl().findAll();
//        final List<String> projectsWithDate = new ArrayList<>();
//        for (int i = 1; i <= projectList.size(); i++) {
//            final String name = projectList.get(i - 1).getName();
//            final String firstDate = projectList.get(i - 1).getFirstDate();
//            final long size = new DeveloperRepositoryImpl().getDevelopersFromOneProject((long) i).size();
//            projectsWithDate.add(name + ", " + size + ", " + firstDate);
//        }
//        return projectsWithDate;
//    }
//}
