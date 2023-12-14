package ru.databasePetProject.RestAppUniversityProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.databasePetProject.RestAppUniversityProject.models.Dormitory;
import ru.databasePetProject.RestAppUniversityProject.models.University;
import ru.databasePetProject.RestAppUniversityProject.services.DormitoryService;
import ru.databasePetProject.RestAppUniversityProject.services.UniversityService;

import java.util.List;
@RestController
@RequestMapping("/dormitory")
public class DormitoryController {
    private final DormitoryService dormitoryService;

    @Autowired
    public DormitoryController(DormitoryService dormitoryService) {
        this.dormitoryService = dormitoryService;
    }
    @GetMapping()
    public List<Dormitory> getUniversity() {
        return dormitoryService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Dormitory> getUniversityById(@PathVariable("id") long id) {
        Dormitory dormitory = dormitoryService.getDormitoryById(id);
        return new ResponseEntity<>(dormitory, HttpStatus.OK);

    }
}
