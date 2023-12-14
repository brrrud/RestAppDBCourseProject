package ru.databasePetProject.RestAppUniversityProject.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.databasePetProject.RestAppUniversityProject.models.University;
import ru.databasePetProject.RestAppUniversityProject.repositories.UniversityRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class UniversityService{

    private final UniversityRepository universityRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UniversityService(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public List<University> findAll() {
        return universityRepository.findAll();
    }

    public University getUniversityById(@PathVariable("id") long id) {
        Optional<University> university = universityRepository.findById(id);
        return university.orElse(null);
    }

    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Transactional
    public List<University> findUniversitiesByCriteria(boolean hasGovernmentFunding, boolean hasMilitaryCenter, boolean hasDormitories, double minRating) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<University> query = cb.createQuery(University.class);
        Root<University> university = query.from(University.class);

        List<Predicate> predicates = new ArrayList<>();
        if (hasGovernmentFunding) {
            predicates.add(cb.equal(university.get("hasGovernmentFunding"), true));
        }
        if (hasMilitaryCenter) {
            predicates.add(cb.equal(university.get("hasMilitaryCenter"), true));
        }
        if(hasDormitories) {
            predicates.add(cb.isNotEmpty(university.get("dormitories")));
        }
        if(minRating != 0.0) {
            predicates.add(cb.greaterThanOrEqualTo(university.get("rating"), minRating));
        }

        query.where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
    @Transactional
    public University findUniversitiesByName(String name) {
        return universityRepository.findByName(name);
    }

    @Transactional
    public University addUniversity(University university) {
        return universityRepository.save(university);
    }

    @Transactional
    public University updateUniversity(University university) {
        return universityRepository.save(university);
    }




}




