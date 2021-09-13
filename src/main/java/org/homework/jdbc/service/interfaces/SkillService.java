package org.homework.jdbc.service.interfaces;

import org.homework.jdbc.model.Skill;

public interface SkillService extends IService<Skill, Long> {

    Skill createNewSkill(String activity, String level);

    void update(Long id, String activity, String level);
}
