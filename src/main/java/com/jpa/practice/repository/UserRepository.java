package com.jpa.practice.repository;

import com.jpa.practice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    // Custom query to filter by JSON field (PostgreSQL-specific)
    @Query("SELECT u FROM Users u WHERE JSONB_EXTRACT_PATH_TEXT(u.address, 'city') = :city")
    List<Users> findByCity(String city);
}
