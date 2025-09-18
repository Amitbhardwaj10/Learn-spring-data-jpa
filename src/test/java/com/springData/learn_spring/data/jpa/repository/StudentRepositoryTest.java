package com.springData.learn_spring.data.jpa.repository;

import com.springData.learn_spring.data.jpa.entity.Guardian;
import com.springData.learn_spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("amit@gmail.com")
                .firstName("Amit")
                .lastName("Bhardwaj")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Nikhil")
                .email("nikhil@gmail.com")
                .mobile("928385732")
                .build();
        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("shivam");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("sh");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("nikhil");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("amit@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("amit@gmail.com");
        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("shivam@gmail.com");
        System.out.println("student = " + student);
    }
}
