package org.homework.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Skill implements Serializable, BaseModel<Long> {

    private static final long serialVersionUID = 1928544651928374654L;

    private Long id;
    private String activities, level;
}
