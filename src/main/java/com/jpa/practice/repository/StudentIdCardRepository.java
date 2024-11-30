package com.jpa.practice.repository;

import com.jpa.practice.model.StudentIdCard;
import org.springframework.data.repository.CrudRepository;

public interface StudentIdCardRepository extends CrudRepository<StudentIdCard, Integer> {
}
