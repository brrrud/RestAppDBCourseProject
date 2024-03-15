package ru.databasePetProject.RestAppUniversityProject.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.databasePetProject.RestAppUniversityProject.models.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
