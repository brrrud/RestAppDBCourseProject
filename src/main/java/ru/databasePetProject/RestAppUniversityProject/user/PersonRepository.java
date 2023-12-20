package ru.databasePetProject.RestAppUniversityProject.user;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.databasePetProject.RestAppUniversityProject.models.Person;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByUsername(String username);
}
