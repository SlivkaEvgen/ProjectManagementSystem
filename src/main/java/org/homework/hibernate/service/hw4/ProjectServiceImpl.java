package org.homework.hibernate.service.hw4;

import org.hibernate.Session;
import org.homework.hibernate.model.Project;
import org.homework.hibernate.model.Skill;
import org.homework.hibernate.repository.ProjectCrudRepositoryImpl;
import org.homework.hibernate.service.hw4.interfaces.ProjectService;
import org.homework.hibernate.utils.SessionsOpenClose;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    private final ProjectCrudRepositoryImpl CRUD_REPOSITORY = new ProjectCrudRepositoryImpl(Project.class);
private final SessionsOpenClose sessionsOpenClose = SessionsOpenClose.getInstance();
    @Override
    public Optional<Project> getById(Long id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<Project> getAll() {
        return CRUD_REPOSITORY.findAll();
    }

    @Override
    public Project createNewProject(String name, Long cost,Long companyId, Long customerId) {
        Project project = new Project();
        project.setName(name);
        project.setCost(cost);
        project.setCompanyId(companyId);
        project.setCustomerId(customerId);
        return CRUD_REPOSITORY.save(project);
    }

    @Override
    public void update(Long id, String name, Long cost) {
        Session session = sessionsOpenClose.createSession();
        session.getTransaction();
        Project project = session.get(Project.class, id);
        project.setName(name);
        project.setCost(cost);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.deleteById(id);
    }

    @Override
    public List<String> getListProjectsWithDate() {
        return CRUD_REPOSITORY.getListProjectsWithDate();
    }
}
