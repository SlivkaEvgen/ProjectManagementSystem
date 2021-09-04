package org.example.jdbc.service;

import org.example.jdbc.model.Skill;
import org.example.jdbc.repository.interfaces.CrudRepository;
import org.example.jdbc.repository.SkillRepositoryImpl;
import org.example.jdbc.service.interfaces.SkillService;

import java.util.List;
import java.util.Optional;

public class SkillServiceImpl implements SkillService {

    private final CrudRepository<Skill, Long> CRUD_REPOSITORY = new SkillRepositoryImpl();

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
        Skill skill = new Skill();
        skill.setActivities(activity);
        skill.setLevel(level);
        return CRUD_REPOSITORY.create(skill);
    }

    @Override
    public void update(Long id, String activity, String level) {
        Skill skill = new Skill();
        skill.setActivities(activity);
        skill.setLevel(level);
        CRUD_REPOSITORY.update(id, skill);
    }

    @Override
    public void delete(Long id) {
        CRUD_REPOSITORY.delete(id);
    }
}
