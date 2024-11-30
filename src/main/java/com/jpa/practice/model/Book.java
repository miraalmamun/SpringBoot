package com.jpa.practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.StringJoiner;


@Entity(name = "Book")
@Table(name = "book")
public class Book {

    @Id
    @SequenceGenerator(name = "Sequence_Book", sequenceName = "Sequence_Book", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequence_Book")
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(name = "book_name", updatable = false)
    private String bookName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne()
    @JoinColumn(name = "student_id", nullable = false, referencedColumnName = "id", foreignKey = @ForeignKey(name = "studentId_book_fk"))
    private Student student;

    public Book() {
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Book(String bookName, LocalDateTime createdAt) {
        this.bookName = bookName;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Student getStudent() {
        return student;
    }



    @Override
    public String toString() {
        return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("bookName='" + bookName + "'")
                .add("createdAt=" + createdAt)
                .add("student=" + student)
                .toString();
    }

    // Lifecycle callback to manage bidirectional relationship before persisting
//    @PrePersist
//    private void prePersist() {
//        if (this.student != null && !this.student.getBooks().contains(this)) {
//            this.student.getBooks().add(this); // Ensure the student side is updated before persisting
//        }
//    }
}
