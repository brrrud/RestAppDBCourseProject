package ru.databasePetProject.RestAppUniversityProject.user;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.databasePetProject.RestAppUniversityProject.auth.AuthenticationRequest;
import ru.databasePetProject.RestAppUniversityProject.models.Person;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PatchMapping
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest request, Principal connectedUser) {
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            service.registerUser(authenticationRequest);
            return ResponseEntity.ok().build();
        }catch (Exception ex) {
            //TODO:logger
            return ResponseEntity.badRequest().build();
        }

    }


}