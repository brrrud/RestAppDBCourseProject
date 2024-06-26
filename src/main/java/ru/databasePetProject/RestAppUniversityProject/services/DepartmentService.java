package ru.databasePetProject.RestAppUniversityProject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import ru.databasePetProject.RestAppUniversityProject.models.Department;
import ru.databasePetProject.RestAppUniversityProject.repositories.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(@PathVariable("id") long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }
    @Transactional
    public Department saveDepartment(Department department) {
        var _department = Optional.of(departmentRepository.save(department));
        return _department.orElse(new Department());
    }
    @Transactional
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
