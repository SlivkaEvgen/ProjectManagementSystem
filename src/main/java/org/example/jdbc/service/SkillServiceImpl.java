package org.example.jdbc.service;

import org.example.jdbc.model.Skill;
import org.example.jdbc.repository.interfaces.CrudRepository;
import org.example.jdbc.repository.SkillRepositoryImpl;
import org.example.jdbc.service.interfaces.SkillService;
import java.util.List;
import java.util.Optional;

public class SkillServiceImpl implements SkillService {

  private final CrudRepository<Skill, Long> crudRepository = new SkillRepositoryImpl();

  @Override
  public Optional<Skill> getById(Long id) {
    return crudRepository.findById(id);
  }

  @Override
  public List<Skill> getAll() {
    return crudRepository.findAll();
  }

  @Override
  public Skill createNewSkill(String activity, String level) {
    Skill skill = new Skill();
    skill.setActivities(activity);
    skill.setLevel(level);
    crudRepository.create(skill);
    return skill;
  }

  @Override
  public void update(Long id, String activity, String level) {
    Skill skill = new Skill();
    skill.setActivities(activity);
    skill.setLevel(level);
    crudRepository.update(id, skill);
  }

  @Override
  public void delete(Long id) {
    crudRepository.delete(id);
  }
}
