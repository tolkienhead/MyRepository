package org.example.servletstarter.dao;

import org.example.servletstarter.entity.Author;

import java.util.List;
import java.util.Optional;

public class BookDao implements Dao{
    private static final BookDao INSTANCE = new BookDao();

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional findById(Object id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Object id) {
        return false;
    }

    @Override
    public Optional<Author> findById(long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public Object save(Object entity) {
        return null;
    }
}
