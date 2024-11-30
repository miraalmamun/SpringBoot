package com.jpa.practice.configuration;

import com.github.javafaker.Faker;
import com.jpa.practice.model.Book;
import com.jpa.practice.model.Course;
import com.jpa.practice.model.Student;
import com.jpa.practice.model.StudentIdCard;
import com.jpa.practice.repository.StudentIdCardRepository;
import com.jpa.practice.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class BeanConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            for (int i = 0; i < 1; i++) {
                studentRepository.deleteById(1);
                Faker faker = new Faker();
                var fname = faker.name().firstName();
                var lname = faker.name().lastName();
                var email = fname + "." + lname + "@gmail.com";
                Student student = new Student(fname, lname, email);
                student.addBook(new Book("Computer", LocalDateTime.now().minusYears(12)));
                student.addBook(new Book("Biology", LocalDateTime.now().minusYears(5)));
                student.addBook(new Book("Phsysic", LocalDateTime.now().minusYears(1)));

                StudentIdCard studentIdCard = new StudentIdCard("12234" + i, student);

                student.setStudentIdCard(studentIdCard);
                student.enrolToCourese(new Course("Java","IT"));
                student.enrolToCourese(new Course("Manthmetics","Science"));


                studentRepository.save(student);

                studentRepository.findById(1).ifPresent(s -> {
                    System.out.println("Fetch book lazy...");
                    student.getBooks().forEach(b -> System.out.println(b.getStudent().getFirstName() + " borrowed " + b.getBookName()));
                });
            }

        };
    }
}
