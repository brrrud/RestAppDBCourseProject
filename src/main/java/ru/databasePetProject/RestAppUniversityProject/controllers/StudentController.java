package ru.databasePetProject.RestAppUniversityProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.models.Student;
import ru.databasePetProject.RestAppUniversityProject.services.StudentService;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping()
    public List<Student> getStudents() {
        return studentService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);

    }
    @PostMapping("/addStudent")
    public Student newStudent(@RequestBody Student newStudent) {
        return studentService.saveStudent(newStudent);
    }
    @PostMapping("/updateStudent")
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {
        Student updated = studentService.updateStudent(student);
        return ResponseEntity.ok("University with ID: " + updated.getIdStudent() + " has been updated");
    }
}
