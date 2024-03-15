package ru.databasePetProject.RestAppUniversityProject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.databasePetProject.RestAppUniversityProject.models.CultureHouse;

public interface CultureHouseRepository extends JpaRepository<CultureHouse, Long> {
}