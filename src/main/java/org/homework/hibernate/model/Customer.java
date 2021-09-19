package org.homework.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "projects")
@ToString(exclude = "projects")
@Entity
@Table(name = "customers")
public class Customer implements BaseModel<Long> {

    private static final long serialVersionUID = 1928374651928374651L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "budget", length = 10)
    private Long budget;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Project> projects;
}
