package ru.databasePetProject.RestAppUniversityProject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ru.databasePetProject.RestAppUniversityProject.models.Faculty;
import ru.databasePetProject.RestAppUniversityProject.repositories.FacultyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }
    public Faculty getFacultyById(@PathVariable("id") long id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty.orElse(null);
    }
    @Transactional
    public Faculty saveFaculty(Faculty faculty) {
        var _faculty = Optional.of(facultyRepository.save(faculty));
        return _faculty.orElse(new Faculty());
    }
    @Transactional
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }
}
