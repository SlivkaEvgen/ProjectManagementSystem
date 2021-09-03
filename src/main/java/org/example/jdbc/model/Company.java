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
public class Company implements Serializable, BaseModel<Long> {

  private static final long serialVersionUID = 1928374651928374653L;

  private Long id,totalCostOfProjects;
  private String name;
}
