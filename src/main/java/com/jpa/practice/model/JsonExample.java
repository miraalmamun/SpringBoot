package com.jpa.practice.model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.util.Map;

@Getter
@Setter
@Entity
@Table(name = "json_example")
public class JsonExample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

     // Store as JSON in the database
     @Type(JsonBinaryType.class) // Specify the type to handle JSON data
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> preferences; // Flexible, JSON-based field

    // Getters and setters
}