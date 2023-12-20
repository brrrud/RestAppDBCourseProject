package ru.databasePetProject.RestAppUniversityProject.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.databasePetProject.RestAppUniversityProject.auth.AuthenticationRequest;
import ru.databasePetProject.RestAppUniversityProject.models.Person;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PasswordEncoder passwordEncoder;
    private final PersonRepository repository;

    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (Person) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setPassword(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        repository.save(user);
    }

    public void registerUser(AuthenticationRequest authenticationRequest)  {

        repository.save(Person.builder().username(authenticationRequest.getUsername()).password(authenticationRequest.getPassword()).role(Role.USER).tokens(List.of()).build());
    }
}