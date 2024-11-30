package com.jpa.practice.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.StringJoiner;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "StudentIdCard")
@Table(name = "student_id_card", uniqueConstraints = {
        @UniqueConstraint(name = "card_number_unique", columnNames = "card_number")
})
public class StudentIdCard {
    @Id
    @SequenceGenerator(name = "Sequence_StudentIdCard", sequenceName = "Sequence_StudentIdCard", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Sequence_StudentIdCard")
    @Column(name = "id", updatable = false)
    private Integer id;
    @Column(name = "card_number", nullable = true, length = 15)
    private String cardNumber;

    //    private LocalDate createdAt;
    //    private LocalDate updateBy;
    //    private String createdBy;
    public StudentIdCard(String cardNumber, Student student) {
        this.cardNumber = cardNumber;
        this.student = student;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "student_id_studentidcard_fk"))
    private Student student;


    @Override
    public String toString() {
        return new StringJoiner(", ", StudentIdCard.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("cardNumber='" + cardNumber + "'")
                .add("student=" + student)
                .toString();
    }
}
