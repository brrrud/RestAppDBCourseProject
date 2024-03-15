package ru.databasePetProject.RestAppUniversityProject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.models.Department;
import ru.databasePetProject.RestAppUniversityProject.models.Faculty;
import ru.databasePetProject.RestAppUniversityProject.services.FacultyService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;
    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping()
    public List<Faculty> getFaculty() {
        return facultyService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable("id") long id) {
        Faculty faculty = facultyService.getFacultyById(id);
        return new ResponseEntity<>(faculty, HttpStatus.OK);

    }
    @PostMapping("/addFaculty")
    public Faculty newFaculty(@RequestBody Faculty newFaculty) {
        return facultyService.saveFaculty(newFaculty);
    }

    @PostMapping("/updateFaculty")
    public ResponseEntity<String> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updated = facultyService.updateFaculty(faculty);
        return ResponseEntity.ok("University with ID: " + updated.getIdFaculty() + " has been updated");
    }
    @GetMapping("/findDepartments/{id}")
    ResponseEntity<List<Department>> findDepartments(@PathVariable("id") long id) {
        List<Department> departments = new ArrayList<>(facultyService.getFacultyById(id).getDepartments());
        return ResponseEntity.ok(departments);
    }
}
