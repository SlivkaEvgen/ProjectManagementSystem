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
public class Customer implements Serializable, BaseModel<Long> {

    private static final long serialVersionUID = 1928374651928374651L;

    private Long id, budget, companyId;
    private String name;
}
