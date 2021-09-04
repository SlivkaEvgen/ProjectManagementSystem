package org.example.jdbc.model;

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

    private Long id, age, numberPhone, companyId, salary;
    private String name, gender, email;
}
