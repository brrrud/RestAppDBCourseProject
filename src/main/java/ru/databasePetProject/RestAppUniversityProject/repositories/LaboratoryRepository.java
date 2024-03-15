package ru.databasePetProject.RestAppUniversityProject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.databasePetProject.RestAppUniversityProject.models.Laboratory;

@Service
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
}
