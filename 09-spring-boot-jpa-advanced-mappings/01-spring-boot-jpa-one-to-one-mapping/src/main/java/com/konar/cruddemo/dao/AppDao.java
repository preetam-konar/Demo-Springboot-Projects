package com.konar.cruddemo.dao;

import com.konar.cruddemo.entity.Instructor;
import com.konar.cruddemo.entity.InstructorDetail;

public interface AppDao {

    public void save(Instructor instructor);

    public Instructor findInstructorById(int id);

    public void deleteInstructorById(int id);

    public InstructorDetail findInstructorDetailById(int id);

    public void deleteInstructorDetailsById(int id);

}
