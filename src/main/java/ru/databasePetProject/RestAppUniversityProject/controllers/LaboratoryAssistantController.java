package ru.databasePetProject.RestAppUniversityProject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.models.LaboratoryAssistant;
import ru.databasePetProject.RestAppUniversityProject.services.LaboratoryAssistantService;

import java.util.List;

@RestController
@RequestMapping(value = "/laboratoryAssistant")
public class LaboratoryAssistantController {
    private final LaboratoryAssistantService laboratoryAssistantService;
    @Autowired
    public LaboratoryAssistantController(LaboratoryAssistantService laboratoryService) {
        this.laboratoryAssistantService = laboratoryService;
    }
    @GetMapping()
    public List<LaboratoryAssistant> getAssistants() {
        return laboratoryAssistantService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LaboratoryAssistant> getAssistantById(@PathVariable("id") long id) {
        LaboratoryAssistant laboratoryAssistant = laboratoryAssistantService.getAssistantById(id);
        return new ResponseEntity<>(laboratoryAssistant, HttpStatus.OK);

    }
    @PostMapping("/addAssistant")
    public LaboratoryAssistant newAssistant(@RequestBody LaboratoryAssistant newAssistant) {
        return laboratoryAssistantService.saveAssistant(newAssistant);
    }
    @PostMapping("/updateAssistant")
    public ResponseEntity<String> updateAssistant(@RequestBody LaboratoryAssistant assistant) {
        LaboratoryAssistant updated = laboratoryAssistantService.updateAssistant(assistant);
        return ResponseEntity.ok("University with ID: " + updated.getIdLaboratoryAssistant() + " has been updated");
    }
}
