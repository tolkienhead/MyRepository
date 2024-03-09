package org.example.servletstarter.dto;

import java.util.Objects;

public class BookDto {
    private final long id;
    private final String description;

    public BookDto(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return id == bookDto.id && Objects.equals(description, bookDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
