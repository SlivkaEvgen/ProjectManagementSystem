package org.example.jdbc.repository.interfaces;

import org.example.jdbc.model.BaseModel;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends BaseModel<ID>, ID> {

  Optional<T> findById(ID id);

  List<T> findAll();

  T create(T t);

  T update(ID id, T t);

  void delete(ID id);
}
