package com.cd.inventorymanagementsystem.domain.students.controllers;

import com.cd.inventorymanagementsystem.domain.students.models.Student;
import com.cd.inventorymanagementsystem.domain.students.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Integer id) {
        Student student = studentService.getById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        Student createdStudent = studentService.create(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable("id") Integer id, @RequestBody Student studentDetail) {
        Student updatedStudent = studentService.update(id, studentDetail);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("appendNote/{id}")
    public ResponseEntity appendNote(@PathVariable("id") Integer id, @RequestBody String note) {
        studentService.appendNote(id, note);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PutMapping("deleteNote/{id}/{noteIndex}")
    public ResponseEntity deleteNote(@PathVariable("id") Integer id, @PathVariable("noteIndex") int noteIndex) {
        studentService.deleteNote(id, noteIndex);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
