package org.homework.jdbc.model;

@FunctionalInterface
public interface BaseModel<ID> {
    ID getId();
}
