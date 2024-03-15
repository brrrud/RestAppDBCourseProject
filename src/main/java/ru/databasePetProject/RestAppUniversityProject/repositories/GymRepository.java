package ru.databasePetProject.RestAppUniversityProject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.databasePetProject.RestAppUniversityProject.models.Gym;

public interface GymRepository extends JpaRepository<Gym, Long> {
}
