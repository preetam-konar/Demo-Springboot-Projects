package com.konar.cruddemo;

import com.konar.cruddemo.dao.AppDao;
import com.konar.cruddemo.entity.Instructor;
import com.konar.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

            deleteInstructorDetail(appDao);
        };
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
