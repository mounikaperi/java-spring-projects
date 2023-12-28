package com.springpractice.springboot;

import org.springframework.aot.generate.GeneratedClass;
import org.springframework.aot.generate.GeneratedMethod;

import javax.annotation.processing.Generated;

public class Course {
    private Long id;
    private String name;
    private String author;
    public Course() {

    }
    public Course(Long id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id.equals(course.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
