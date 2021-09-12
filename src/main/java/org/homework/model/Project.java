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
public class Project implements Serializable, BaseModel<Long> {

    private static final long serialVersionUID = 1828374651928374654L;

    private Long id, companyId, customerId, cost;
    private String name, firstDate;
}
