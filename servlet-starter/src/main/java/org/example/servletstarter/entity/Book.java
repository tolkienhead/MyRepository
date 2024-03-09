package org.example.servletstarter.entity;

import java.util.Objects;

public class Book {
    Integer id;
    String title;
    String isbn;
    Integer publisher_id;

    public Book(Integer id, String title, String isbn, Integer publisher_id) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.publisher_id = publisher_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(Integer publisher_id) {
        this.publisher_id = publisher_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher_id=" + publisher_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(isbn, book.isbn) && Objects.equals(publisher_id, book.publisher_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isbn, publisher_id);
    }
}
