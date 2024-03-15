package ru.databasePetProject.RestAppUniversityProject.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import ru.databasePetProject.RestAppUniversityProject.models.DiningRoom;

public interface DiningRoomRepository extends JpaRepository<DiningRoom, Long> {
}
