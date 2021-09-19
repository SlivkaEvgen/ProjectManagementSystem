package org.homework.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "developers")
@ToString(exclude = "developers")
@Entity
@Table(name = "skills")
public class Skill implements BaseModel<Long> {

    private static final long serialVersionUID = 1928544651928374654L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "activities", length = 30)
    private String activities;

    @Column(name = "level", length = 30)
    private String level;

    @ManyToMany(mappedBy = "skills",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Developer> developers;
}
