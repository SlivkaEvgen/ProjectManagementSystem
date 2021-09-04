package org.example.jdbc.service;

import org.example.jdbc.model.Project;
import org.example.jdbc.repository.interfaces.ProjectRepository;
import org.example.jdbc.repository.ProjectRepositoryImpl;
import org.example.jdbc.service.interfaces.ProjectService;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository PROJECT_REPOSITORY = new ProjectRepositoryImpl();

    @Override
    public Optional<Project> getById(Long id) {
        return PROJECT_REPOSITORY.findById(id);
    }

    @Override
    public List<Project> getAll() {
        return PROJECT_REPOSITORY.findAll();
    }

    @Override
    public Project createNewProject(String name, Long cost, Long companyId, Long customerId) {
        Project project = new Project();
        project.setName(name);
        project.setCost(cost);
        project.setCompanyId(companyId);
        project.setCustomerId(customerId);
        return PROJECT_REPOSITORY.create(project);
    }

    @Override
    public void update(Long id, String name, Long cost, Long companyId, Long customerId) {
        Project project = new Project();
        project.setName(name);
        project.setCost(cost);
        project.setCompanyId(companyId);
        project.setCustomerId(customerId);
        PROJECT_REPOSITORY.update(id, project);
    }

    @Override
    public void delete(Long id) {
        PROJECT_REPOSITORY.delete(id);
    }

    @Override
    public List<String> getListProjectsWithDate() {
        return PROJECT_REPOSITORY.getListProjectsWithDate();
    }
}
