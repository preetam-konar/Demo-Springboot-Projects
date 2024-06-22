package com.konar.cruddemo.dao;

import com.konar.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    public void save(Student theStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    public List<Student> findByLastName(String lastName);

    public Student update(Student theStudent);

    public void delete(Integer id);

    public int deleteAll();
}
