package org.example.servletstarter.service;

import org.example.servletstarter.dao.AuthorDao;
import org.example.servletstarter.dto.AuthorDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AuthorService {
    private static final AuthorService INSTANCE = new AuthorService();

    private AuthorService() {
    }

    private final AuthorDao authorDao = AuthorDao.getInstance();
    public List<AuthorDto> findAll(){
        return authorDao.findAll().stream()
                .map(author -> new AuthorDto(
                        author.getId(),
                        """
                                %s - %s
                                """.formatted(author.getFullName(),author.getRating())
                        )
                )
                .collect(toList());
    }

    public static AuthorService getInstance(){
        return INSTANCE;
    }
}
