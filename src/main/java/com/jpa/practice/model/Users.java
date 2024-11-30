package com.jpa.practice.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @SequenceGenerator(name = "Sequence_Users", sequenceName = "Sequence_Users", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequence_Users")
    @Column(name = "id", updatable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "jsonb") // Specifies that the column is JSONB in the database
    private String address; // JSON data stored as a String

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
