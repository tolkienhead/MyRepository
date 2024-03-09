package org.example.servletstarter.service;

import org.example.servletstarter.dao.BookDao;
import org.example.servletstarter.dto.AuthorDto;
import org.example.servletstarter.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private final static BookService  INSTANCE = new BookService();

    public BookService() {}

    private final BookDao bookDao = BookDao.getINSTANCE();

    public List<BookDto> findAll(){
        return bookDao.findAll().stream()
                .map(book ->
                        new BookDto(
                                book.getId(),
                                """
                                %s %s %s
                               """.formatted(book.getTitle(),book.getIsbn(), book.getPublisher_id())
                                )
                )
                .collect(Collectors.toList());
    }

    public List<BookDto> findAllByAuthorId(Integer author_id){
        return bookDao.findAllByAuthorId(author_id).stream()
                .map(book ->
                        new BookDto(
                                book.getId(),
                                """
                                        %s - %s - %s
                                        """.formatted(book.getTitle(),book.getIsbn(), book.getPublisher_id())
                                )
                )
                .collect(Collectors.toList());
    }

    public static BookService getINSTANCE() {
        return INSTANCE;
    }
}
