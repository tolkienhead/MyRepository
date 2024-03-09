package org.example.servletstarter.dao;

import org.example.servletstarter.entity.Author;
import org.example.servletstarter.entity.Book;
import org.example.servletstarter.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDao implements Dao<Integer,Book>{
    private static final BookDao INSTANCE = new BookDao();

    private final static String FIND_ALL = """
        SELECT * 
        FROM book
       """;

    private final static String FIND_ALL_BY_AUTHOR_ID_FROM_BOOK_AUTHOR = """
                SELECT book.book_id, title, isbn, fk_publisher_id
                FROM book
                JOIN book_author ba on book.book_id = ba.book_id
                WHERE author_id = ?;
            """;

    private BookDao(){};

    @Override
    public List<Book> findAll() {
        try(
                Connection connection = ConnectionManager.get();
                final PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)
                )
        {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while(resultSet.next()){
                bookList.add(buildBook(resultSet));
            }
            return bookList;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Book buildBook(ResultSet resultSet) throws SQLException {
        return new Book(
                resultSet.getObject("book_id", Integer.class),
                resultSet.getObject("title", String.class),
                resultSet.getObject("isbn", String.class),
                resultSet.getObject("fk_publisher_id", Integer.class)
        );
    }

    public List<Book> findAllByAuthorId(Integer id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_AUTHOR_ID_FROM_BOOK_AUTHOR)){
            preparedStatement.setObject(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (resultSet.next()){
                bookList.add(buildBook(resultSet));
            }
            return bookList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
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
    public void update(Book entity) {

    }

    @Override
    public Book save(Book entity) {
        return null;
    }

    public static BookDao getINSTANCE() {
        return INSTANCE;
    }
}
