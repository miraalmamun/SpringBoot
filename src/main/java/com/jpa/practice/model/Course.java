package com.jpa.practice.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Course")
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(name = "Sequence_Course", sequenceName = "Sequence_Course", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequence_Course")
    @Column(name = "id", updatable = false)
    private Integer id;
    private String name;
    private String department;

    public Course(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @ManyToMany(
            mappedBy = "courses"
    )
    private List<Student> students = new ArrayList<>();

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("department='" + department + "'")
                .toString();
    }
}
