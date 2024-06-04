package com.cd.inventorymanagementsystem.domain.students.services;

import com.cd.inventorymanagementsystem.domain.students.models.Student;

import java.util.List;

public interface StudentService {
    Student create(Student student);
    Student getById(Integer id);
    List<Student> getAll();
    Student update(Integer id, Student studentDetail);
    void delete(Integer id);

    void appendNote(Integer id, String note);

    void deleteNote(Integer id, int noteIndex);
}
