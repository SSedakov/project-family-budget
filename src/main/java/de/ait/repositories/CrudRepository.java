package de.ait.repositories;

import java.util.Optional;
public interface CrudRepository<T> {
    void save(T model);
    T findById(String id);
}
