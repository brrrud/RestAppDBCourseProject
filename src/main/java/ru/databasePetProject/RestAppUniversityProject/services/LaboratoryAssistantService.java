package ru.databasePetProject.RestAppUniversityProject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ru.databasePetProject.RestAppUniversityProject.models.LaboratoryAssistant;
import ru.databasePetProject.RestAppUniversityProject.repositories.LaboratoryAssistantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryAssistantService {
    private final LaboratoryAssistantRepository laboratoryAssistantRepository;
    @Autowired
    public LaboratoryAssistantService(LaboratoryAssistantRepository laboratoryRepository) {
        this.laboratoryAssistantRepository = laboratoryRepository;
    }
    public List<LaboratoryAssistant> findAll() {
        return laboratoryAssistantRepository.findAll();
    }
    public LaboratoryAssistant getAssistantById(@PathVariable("id") long id) {
        Optional<LaboratoryAssistant> laboratoryAssistant = laboratoryAssistantRepository.findById(id);
        return laboratoryAssistant.orElse(null);
    }
    @Transactional
    public LaboratoryAssistant saveAssistant(LaboratoryAssistant laboratoryAssistant) {
        var _assistant = Optional.of(laboratoryAssistantRepository.save(laboratoryAssistant));
        return _assistant.orElse(new LaboratoryAssistant());
    }
    @Transactional
    public LaboratoryAssistant updateAssistant(LaboratoryAssistant laboratoryAssistant) {
        return laboratoryAssistantRepository.save(laboratoryAssistant);
    }
}
