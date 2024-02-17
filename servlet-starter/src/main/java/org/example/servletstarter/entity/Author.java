package org.example.servletstarter.entity;

import java.util.Objects;

public class Author {
    Integer id;
    String fullName;
    Float rating;

    public Author(Integer id, String fullName, Float rating) {
        this.id = id;
        this.fullName = fullName;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Author{" +
               "id=" + id +
               ", fullName='" + fullName + '\'' +
               ", rating=" + rating +
               '}';
    }
}
