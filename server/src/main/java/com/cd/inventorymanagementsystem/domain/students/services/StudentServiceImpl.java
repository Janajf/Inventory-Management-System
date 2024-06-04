package com.cd.inventorymanagementsystem.domain.students.services;

import com.cd.inventorymanagementsystem.domain.students.models.Student;
import com.cd.inventorymanagementsystem.domain.students.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements  StudentService{
    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student getById(Integer id) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student create(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student update(Integer id, Student student) {
        if (studentRepo.existsById(id)) {
            student.setId(id);
            return studentRepo.save(student);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        studentRepo.deleteById(id);
    }


    @Override
    public void appendNote(Integer id, String note) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.getNotes().add(note);

        studentRepo.save(student);
    }
    @Override
    public void deleteNote(Integer id, int noteIndex) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        try {
            List<String> notes = student.getNotes();
            System.out.println(notes);
            notes.remove(noteIndex);
            System.out.println(notes);
            student.setNotes(notes);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        studentRepo.save(student);
    }
}
