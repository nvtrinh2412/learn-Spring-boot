package com.example.demo.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @Test
    void selectExistsEmail() {
        //given
        String email = "trinhngaytho69@gmail.com";
        Student student = new Student(
                "Justin",
                email,
                LocalDate.of(2000,1,1));
        //when
        underTest.save(student);
        boolean expected =  underTest.selectExistsEmail(email);

        //then
        assertThat(expected).isTrue();
    }
}