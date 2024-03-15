package ru.databasePetProject.RestAppUniversityProject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.databasePetProject.RestAppUniversityProject.models.StudyGroup;

public interface StudyGroupRepository extends JpaRepository<StudyGroup, Long> {
}
