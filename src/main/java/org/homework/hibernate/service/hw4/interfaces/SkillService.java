package org.homework.hibernate.service.hw4.interfaces;

import org.homework.hibernate.model.Skill;

public interface SkillService extends IService<Skill, Long> {

    Skill createNewSkill(String activity, String level);

    void update(Long id, String activity, String level);
}
