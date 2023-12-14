package ru.databasePetProject.RestAppUniversityProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.databasePetProject.RestAppUniversityProject.models.University;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {
    University findByName(String name);

}
