package com.konar.cruddemo;

import com.konar.cruddemo.dao.AppDao;
import com.konar.cruddemo.entity.Course;
import com.konar.cruddemo.entity.Instructor;
import com.konar.cruddemo.entity.InstructorDetail;
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
//            createInstructor(appDao);

//            findInstructor(appDao);

//            deleteInstructor(appDao);

//            findInstructorDetail(appDao);

//            deleteInstructorDetail(appDao);

//            createInstructorWithCourses(appDao);

//            findCoursesForInstructor(appDao);

//            findInstructorUsingJoinFetch(appDao);

            deleteCourse(appDao);

//            updateCourse(appDao);

//            updateInstructor(appDao);
        };
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
