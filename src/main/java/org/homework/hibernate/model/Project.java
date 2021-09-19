package org.homework.hibernate.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"company","customer","developers"})
@ToString(exclude = {"company","customer","developers"})
@Entity
@Table(name = "projects")
public class Project implements BaseModel<Long> {

    private static final long serialVersionUID = 1828374651928374654L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "cost", length = 10)
    private Long cost;

    @Column(name = "company_id", length = 10,insertable = false,updatable = false)
    private Long companyId;

    @Column(name = "customer_id", length = 10,insertable = false,updatable = false)
    private Long customerId;

    @Column(name = "first_date", length = 40)
    private String firstDate;

    @ManyToOne
    @JoinColumn(name = "company_id",insertable = false,updatable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(mappedBy = "projects",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Developer> developers;
}
