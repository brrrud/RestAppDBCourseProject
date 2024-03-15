package ru.databasePetProject.RestAppUniversityProject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.models.Department;
import ru.databasePetProject.RestAppUniversityProject.models.EducationalDirection;
import ru.databasePetProject.RestAppUniversityProject.models.Laboratory;
import ru.databasePetProject.RestAppUniversityProject.services.DepartmentService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/depratment")
public class DepartmentController {
    private final DepartmentService departmentService;
    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping()
    public List<Department> getDepartments() {
        return departmentService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
        Department department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);

    }
    @PostMapping("/addDepartment")
    public Department newDepartment(@RequestBody Department newDepartment) {
        return departmentService.saveDepartment(newDepartment);
    }
    @PostMapping("/updateDepartment")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
        Department updated = departmentService.updateDepartment(department);
        return ResponseEntity.ok("University with ID: " + updated.getIdDepartment() + " has been updated");
    }
    @GetMapping("/findLaboratories/{id}")
    ResponseEntity<List<Laboratory>> findLaboratories(@PathVariable("id") long id) {
        List<Laboratory> laboratories = new ArrayList<>(departmentService.getDepartmentById(id).getLaboratories());
        return ResponseEntity.ok(laboratories);
    }
    @GetMapping("/findEducationalDirections/{id}")
    ResponseEntity<List<EducationalDirection>> findDirections(@PathVariable("id") long id) {
        List<EducationalDirection> directions = new ArrayList<>(departmentService.getDepartmentById(id).getEducationalDirections());
        return ResponseEntity.ok(directions);
    }
}
