package ru.databasePetProject.RestAppUniversityProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ru.databasePetProject.RestAppUniversityProject.models.Dormitory;
import ru.databasePetProject.RestAppUniversityProject.models.University;
import ru.databasePetProject.RestAppUniversityProject.repositories.DormitoryRepository;
import ru.databasePetProject.RestAppUniversityProject.repositories.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DormitoryService {

    private final DormitoryRepository dormitoryRepository;

    @Autowired
    public DormitoryService(DormitoryRepository dormitoryRepository) {
        this.dormitoryRepository = dormitoryRepository;
    }

    public List<Dormitory> findAll() {
        return dormitoryRepository.findAll();
    }
    public Dormitory getDormitoryById(@PathVariable("id") long id) {
        Optional<Dormitory> dormitory = dormitoryRepository.findById(id);
        return dormitory.orElse(null);
    }


}

