package ru.databasePetProject.RestAppUniversityProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.databasePetProject.RestAppUniversityProject.models.EducationalDirection;

public interface EducationalDirectionRepository extends JpaRepository<EducationalDirection, Long> {
}
