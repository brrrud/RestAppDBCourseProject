package ru.databasePetProject.RestAppUniversityProject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.databasePetProject.RestAppUniversityProject.models.CultureHouseActivity;
import ru.databasePetProject.RestAppUniversityProject.services.CultureHouseService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/culture_house")

public class CultureHouseController {
    private final CultureHouseService cultureHouseService;
    @Autowired
    public CultureHouseController(CultureHouseService cultureHouse) {
        this.cultureHouseService = cultureHouse;
    }
    @GetMapping("/findActivities/{id}")
    ResponseEntity<List<CultureHouseActivity>> findActivities(@PathVariable("id") long id) {
        List<CultureHouseActivity> activities = new ArrayList<>(cultureHouseService.findCultureHouseById(id).getCultureHouseActivities());
        return ResponseEntity.ok(activities);
    }
}
