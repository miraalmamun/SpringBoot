package com.jpa.practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
//@Builder
@Entity(name = "Student")
@Table(name = "student", uniqueConstraints = {@UniqueConstraint(name = "student_email_unique", columnNames = "email")})
public class Student {
    @Id
    @SequenceGenerator(name = "Sequence_Student", sequenceName = "Sequence_Student", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequence_Student")
    @Column(name = "id", updatable = false)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;


    @OneToOne(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private StudentIdCard studentIdCard;

    @OneToMany(mappedBy = "student", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(name = "enrolment", joinColumns = @JoinColumn(name = "student_id"), foreignKey = @ForeignKey(
            name = "enrolment_student_id_fk"
    ), inverseJoinColumns = @JoinColumn(
            name = "course_id",
            foreignKey = @ForeignKey(name = "enrolment_course_id_fk")
    ))
    private List<Course> courses = new ArrayList<>();

    public void enrolToCourese(Course course){
          courses.add(course);
          course.getStudents().add(this);
    }

    public void unEnrolToCourese(Course course){
        courses.remove(course);
        course.getStudents().remove(this);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public StudentIdCard getStudentIdCard() {
        return studentIdCard;
    }

    public void setStudentIdCard(StudentIdCard studentIdCard) {
        this.studentIdCard = studentIdCard;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public void addBook(Book book) {
        if (!this.books.contains((book))) {
            this.books.add(book);
            book.setStudent(this);
        }
    }

    public void removeBook(Book book) {
        if (this.books.contains(book)) {
            this.books.remove(book);
            book.setStudent(null);
        }
    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]").add("id=" + id).add("firstName='" + firstName + "'").add("lastName='" + lastName + "'").add("email='" + email + "'").add("studentIdCard=" + studentIdCard).add("books=" + books).toString();
    }


// Lifecycle callback to synchronize relationships before removal
//    @PreRemove
//    private void preRemove() {
//        for (Book book : books) {
//            book.setStudent(null); // Break the relationship before the student is removed
//        }
//    }

}
