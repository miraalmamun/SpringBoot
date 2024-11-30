package com.jpa.practice.service;

import com.jpa.practice.model.Book;
import com.jpa.practice.model.Student;

public class StudentService {
    public void addBookToStudent(Student student, Book book) {
        student.getBooks().add(book);
        book.setStudent(student);
    }

    public void removeBookFromStudent(Student student, Book book) {
        student.getBooks().remove(book);
        book.setStudent(null);
    }
}
