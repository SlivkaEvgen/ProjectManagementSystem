package org.example.jdbc.model;

@FunctionalInterface
public interface BaseModel<ID> {
    ID getId();
}
