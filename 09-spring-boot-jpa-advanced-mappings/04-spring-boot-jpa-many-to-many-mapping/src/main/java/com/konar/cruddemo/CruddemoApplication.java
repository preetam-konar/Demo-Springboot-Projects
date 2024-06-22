package com.konar.cruddemo;

import com.konar.cruddemo.dao.AppDao;
import com.konar.cruddemo.entity.*;
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
    public CommandLineRunner commandLineRunner(AppDao appDao) {
        return runner -> {

//            createCourseAndStudents(appDao);

//            findCourseAndStudentsByCourseId(appDao);

//            findStudentAndCoursesByStudentId(appDao);

//            addCoursesToStudents(appDao);

//            deleteCourse(appDao);

            deleteStudent(appDao);
        };
    }

    private void deleteStudent(AppDao appDao) {
        int id = 2;
        System.out.println("Delete student with id : " + id);
        appDao.deleteStudentById(id);
        System.out.println("Done");
    }

    private void addCoursesToStudents(AppDao appDao) {
        Student student = appDao.findStudentAndCoursesByStudentId(2);
        student.addCourse(new Course("DSA"));
        student.addCourse(new Course("OOPS"));
        System.out.println("Updating student");
        appDao.update(student);
        System.out.println("Done!");
    }

    private void findStudentAndCoursesByStudentId(AppDao appDao) {
        int id = 1;
        Student student = appDao.findStudentAndCoursesByStudentId(id);
        System.out.println(student);
        System.out.println(student.getCourses());
        System.out.println("Done!");
    }

    private void findCourseAndStudentsByCourseId(AppDao appDao) {
        int id = 10;
        Course course = appDao.findCourseAndStudentsByCourseId(id);
        System.out.println("Finding course with id : " + id);
        System.out.println(course);
        System.out.println(course.getStudents());
        System.out.println("Done");

    }

    private void createCourseAndStudents(AppDao appDao) {

        Course course = new Course("DBMS");

        Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
        Student tempStudent2 = new Student("Susan", "Mary", "susan@gmail.com");

        course.addStudent(tempStudent1);
        course.addStudent(tempStudent2);

        System.out.println("Adding Course : ");

        appDao.save(course);

        System.out.println("Done!");

    }

    private void retrieveCourseAndReviews(AppDao appDao) {

        int id = 10;
        System.out.println("Fetching course with id : " + id);
        Course course = appDao.findCourseAndReviewsByCourseId(id);
        System.out.println(course);

    }

    private void createCourseAndReviews(AppDao appDao) {

        Course course = new Course("DBMS");

        Review review1 = new Review("Database");
        Review review2 = new Review("Database");
        Review review3 = new Review("Database");
        course.addReviews(review1);
        course.addReviews(review2);
        course.addReviews(review3);
        appDao.save(course);
        System.out.println("Course Saved!");

    }

    private void updateInstructor(AppDao appDao) {
        int id = 1;
        Instructor instructor = appDao.findInstructorById(1);
        instructor.setLastName("Smith");
        appDao.update(instructor);

    }

    private void updateCourse(AppDao appDao) {

        int id = 10;
        Course course = appDao.findCourseById(10);
        course.setTitle("DAA");
        appDao.update(course);

    }

    private void deleteCourse(AppDao appDao) {

        int id = 10;
        appDao.deleteCourseById(id);
        System.out.println("Deleted course with id : " + id);

    }

    private void findInstructorUsingJoinFetch(AppDao appDao) {

        int id = 1;
        Instructor instructor = appDao.findInstructorByIdJoinFetch(id);
        System.out.println(instructor);

    }

    private void findCoursesForInstructor(AppDao appDao) {

        int id = 1;
        System.out.println("Fetching instructor");
        Instructor instructor = appDao.findInstructorById(id);
        System.out.println("Fetching courses");
        List<Course> courses = appDao.findCourseByInstructorId(id);
        System.out.println("Setting courses for instructor");
        instructor.setCourse(courses);
        System.out.println(instructor);


    }

    private void createInstructorWithCourses(AppDao appDao) {

        Instructor instructor = new Instructor("John", "Doe", "john@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "coding");
        Course tempCourse1 = new Course("DSA");
        Course tempCourse2 = new Course("OOPS");
        instructor.addCourse(tempCourse1);
        instructor.addCourse(tempCourse2);
        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving Instructor");
        appDao.save(instructor);
        System.out.println("Done!!");

    }

    private void deleteInstructorDetail(AppDao appDao) {

        int id = 4;
        System.out.println("Deleting instructor detail with id : " + id);
        appDao.deleteInstructorDetailsById(id);
        System.out.println("Done!");

    }

    private void findInstructorDetail(AppDao appDao) {

        int id = 2;

        InstructorDetail instructorDetail = appDao.findInstructorDetailById(id);

        System.out.println("Instructor Detail with id : " + id);
        System.out.println(instructorDetail);
        Instructor instructor = instructorDetail.getInstructor();
        System.out.println(instructor);

    }

    private void deleteInstructor(AppDao appDao) {

        int id = 1;
        System.out.println("Deleting instructor with id : " + id);

        appDao.deleteInstructorById(id);
        System.out.println("Deleted");

    }

    private void findInstructor(AppDao appDao) {

        int id = 1;

        Instructor theInstructor = appDao.findInstructorById(id);

        System.out.println("Finding instructor with id : " + id);
        System.out.println(theInstructor);

    }

    private void createInstructor(AppDao appDao) {

        Instructor instructor = new Instructor("John", "Doe", "john@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com", "coding");
        instructor.setInstructorDetail(instructorDetail);
        System.out.println("Saving Instructor");
        appDao.save(instructor);
        System.out.println("Done!!");

    }


}
