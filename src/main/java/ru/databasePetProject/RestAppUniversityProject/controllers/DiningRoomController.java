package ru.databasePetProject.RestAppUniversityProject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.models.DiningRoom;
import ru.databasePetProject.RestAppUniversityProject.services.DiningRoomService;

import java.util.List;

@RestController
@RequestMapping(value = "/diningroom")
public class DiningRoomController {
    private final DiningRoomService diningRoomService;
    @Autowired
    public DiningRoomController(DiningRoomService diningRoomService) {
        this.diningRoomService = diningRoomService;
    }
    @GetMapping()
    public List<DiningRoom> getDiningRooms() {
        return diningRoomService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<DiningRoom> getDiningRoomById(@PathVariable("id") long id) {
        DiningRoom diningRoom = diningRoomService.getDiningRoomById(id);
        return new ResponseEntity<>(diningRoom, HttpStatus.OK);

    }
    @PostMapping("/addDiningRoom")
    public DiningRoom newDiningRoom(@RequestBody DiningRoom newDiningRoom) {
        return diningRoomService.saveDiningRoom(newDiningRoom);
    }
    @PostMapping("/updateDiningRoom")
    public ResponseEntity<String> updateDiningRoom(@RequestBody DiningRoom diningRoom) {
        DiningRoom updated = diningRoomService.updateDiningRoom(diningRoom);
        return ResponseEntity.ok("University with ID: " + updated.getIdDiningRoom() + " has been updated");
    }
}
