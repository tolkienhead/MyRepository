package org.example.servletstarter.dao;

import org.example.servletstarter.entity.Author;
import org.example.servletstarter.util.ConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDao implements Dao<Long, Author>{
    private static final AuthorDao INSTANCE = new AuthorDao();
    private final static String FIND_ALL = """
        SELECT * 
        FROM author
       """;

    private AuthorDao() {
    }

    @Override
    public List<Author> findAll() {
        try(var connection = ConnectionManager.get();
            final var preparedStatement = connection.prepareStatement(FIND_ALL)
        )
        {
            var resultSet = preparedStatement.executeQuery();
            List<Author> authors = new ArrayList<>();

            while (resultSet.next()){
                authors.add(buildAuthor(resultSet));
            }

            return authors;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Author buildAuthor(ResultSet resultSet) throws SQLException {
        return new Author(
            resultSet.getObject("author_id", Integer.class),
            resultSet.getObject("full_name", String.class),
            resultSet.getObject("rating", Float.class)
        );
    }

    @Override
    public Optional<Author> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
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
    public void update(Author entity) {

    }

    @Override
    public Author save(Author entity) {
        return null;
    }

    public static AuthorDao getInstance(){
        return INSTANCE;
    }

}
