package com.jpa.practice.repository;

import com.jpa.practice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT MIN(s.id) FROM Student s")
    Optional<Integer> findFirstStudentId();
}
