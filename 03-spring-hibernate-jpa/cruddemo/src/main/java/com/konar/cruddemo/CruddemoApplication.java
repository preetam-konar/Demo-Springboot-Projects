package com.konar.cruddemo;

import com.konar.cruddemo.dao.StudentDao;
import com.konar.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            deleteAllStudents(studentDao);
        };
    }

    private void deleteAllStudents(StudentDao studentDao) {
        int numOfRowsDeleted = studentDao.deleteAll();
        System.out.println("Num of rows deleted: " + numOfRowsDeleted);
    }

    private void deleteStudent(StudentDao studentDao) {
        studentDao.delete(1);
    }

    private void updateStudent(StudentDao studentDao) {
        Student tempStudent = studentDao.findById(1);
        tempStudent.setFirstName("Java");
        studentDao.update(tempStudent);

    }

    private void getStudentByLastName(StudentDao studentDao) {
        String lastName = "Brown";
        studentDao.findByLastName(lastName).forEach(System.out::println);
    }

    private void findStudent(StudentDao studentDao) {
        Student tempStudent = new Student("Jane", "Doe", "jane@gmail.com");
        studentDao.save(tempStudent);
        Integer id = tempStudent.getId();
        Student resStudent = studentDao.findById(id);
        System.out.println("Student with id: " + id + "\n"+resStudent);
    }

    private void findAllStudents(StudentDao studentDao) {
        List<Student> studentList = studentDao.findAll();
        studentList.forEach(System.out::println);
    }

    private void createStudent(StudentDao studentDao) {

        Student tempStudent = new Student("Jackie", "Chan", "jackie@gmail.com");

        studentDao.save(tempStudent);

        System.out.println("Created student " + tempStudent.getId());

    }

}
