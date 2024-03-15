package ru.databasePetProject.RestAppUniversityProject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.models.EducationalDirection;
import ru.databasePetProject.RestAppUniversityProject.services.EducationalDirectionService;

import java.util.List;

@RestController
@RequestMapping(value = "/educationaldirection")
public class EducationalDirectionController {
    private final EducationalDirectionService educationalDirectionService;
    @Autowired
    public EducationalDirectionController(EducationalDirectionService educationalDirectionService) {
        this.educationalDirectionService = educationalDirectionService;
    }
    @GetMapping()
    public List<EducationalDirection> getDirections() {
        return educationalDirectionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationalDirection> getDirectionById(@PathVariable("id") long id) {
        EducationalDirection direction = educationalDirectionService.getEducationalDirectionById(id);
        return new ResponseEntity<>(direction, HttpStatus.OK);

    }
    @PostMapping("/addDirection")
    public EducationalDirection newDirection(@RequestBody EducationalDirection newDirection) {
        return educationalDirectionService.saveDirection(newDirection);
    }

    @PostMapping("/updateDirection")
    public ResponseEntity<String> updateDirection(@RequestBody EducationalDirection direction) {
        EducationalDirection updated = educationalDirectionService.updateDirection(direction);
        return ResponseEntity.ok("University with ID: " + updated.getIdEducationalDirection() + " has been updated");
    }



}
