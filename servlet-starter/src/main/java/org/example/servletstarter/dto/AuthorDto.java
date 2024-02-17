package org.example.servletstarter.dto;

import java.util.Objects;

public class AuthorDto {
    private final long id;
    private final String description;

    public AuthorDto(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
               "id=" + id +
               ", description='" + description + '\'' +
               '}';
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return id == authorDto.id && Objects.equals(description, authorDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
