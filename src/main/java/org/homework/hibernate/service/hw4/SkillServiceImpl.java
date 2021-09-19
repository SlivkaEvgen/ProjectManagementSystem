package org.homework.hibernate.service.hw4;

import org.hibernate.Session;
import org.homework.hibernate.model.Skill;
import org.homework.hibernate.repository.CrudRepository;
import org.homework.hibernate.repository.RepositoryFactory;
import org.homework.hibernate.service.hw4.interfaces.SkillService;
import org.homework.hibernate.utils.SessionsOpenClose;

import java.util.List;
import java.util.Optional;

public class SkillServiceImpl implements SkillService {

    private final CrudRepository<Skill, Long> CRUD_REPOSITORY = RepositoryFactory.of(Skill.class);

    private final SessionsOpenClose sessionsOpenClose = SessionsOpenClose.getInstance();

    @Override
    public Optional<Skill> getById(Long id) {
        return CRUD_REPOSITORY.findById(id);
    }

    @Override
    public List<Skill> getAll() {
        return CRUD_REPOSITORY.findAll();
    }

    @Override
    public Skill createNewSkill(String activity, String level) {
        Skill skill = Skill.builder()
                .activities(activity)
                .level(level)
                .build();
        return CRUD_REPOSITORY.save(skill);
    }

    @Override
    public void update(Long id, String activity, String level) {
        Session session = sessionsOpenClose.createSession();
        Skill skill = session.get(Skill.class, id);
        skill.setActivities(activity);
        skill.setLevel(level);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.deleteById(id);
    }
}
