package org.example.servletstarter.dao;

import org.example.servletstarter.entity.Author;

import java.util.List;
import java.util.Optional;

public interface Dao <K,T>{
    List<T> findAll();
    Optional<T> findById(K id);
    boolean delete(K id);

    Optional<Author> findById(long id);

    boolean delete(long id);

    void update(T entity);
    T save (T entity);
}
