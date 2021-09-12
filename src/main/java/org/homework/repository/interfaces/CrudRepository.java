package org.homework.repository.interfaces;

import org.homework.model.BaseModel;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends BaseModel<ID>, ID> {

    Optional<T> findById(ID id);

    List<T> findAll();

    T create(T t);

    T update(ID id, T t);

    void delete(ID id);
}
