package com.jpa.practice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.Map;

@Entity
@Table(name = "json_example")
public class JsonExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

     // Store as JSON in the database
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> preferences; // Flexible, JSON-based field

    // Getters and setters
}