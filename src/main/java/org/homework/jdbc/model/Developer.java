package org.homework.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Developer implements BaseModel<Long>, Serializable {

    private static final long serialVersionUID = 1928374651988374656L;

    private Long id;
    private Long age;
    private Long numberPhone;
    private Long companyId;
    private Long salary;
    private String name;
    private String gender;
    private String email;
}
