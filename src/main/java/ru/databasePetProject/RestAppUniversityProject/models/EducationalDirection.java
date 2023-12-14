package ru.databasePetProject.RestAppUniversityProject.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "educational_direction")
public class EducationalDirection {
    @Id
    @Column(name = "id_educational_direction")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEducationalDirection;

    @Column(name = "count_places")
    private long countPlaces;

    @Column(name = "passing_score")
    private short passingScore;

    @Column(name = "educational_type")
    @Enumerated(EnumType.ORDINAL)
    private EducationalType educationalType;

    @Column(name = "educational_cost")
    private long educationalCost;

    @Column(name = "name_educational_direction")
    private String nameEducationalDirection;

    @ManyToOne
    @JoinColumn(name = "fk_id_faculty", referencedColumnName = "id_department")
    private Faculty departmentOwner;


    @ElementCollection(targetClass = EducationalDirectionSubjectsRequired.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "direction_subjects", joinColumns = @JoinColumn(name = "id_educational_direction"))
    @Column(name = "subject")
    private Set<EducationalDirectionSubjectsRequired> subjectsRequired;


    public EducationalDirection(long countPlaces, short passingScore, EducationalType educationalType, long educationalCost, String nameEducationalDirection, Set<EducationalDirectionSubjectsRequired>subjectsRequired) {
        this.countPlaces = countPlaces;
        this.passingScore = passingScore;
        this.educationalType = educationalType;
        this.educationalCost = educationalCost;
        this.nameEducationalDirection = nameEducationalDirection;
        this.subjectsRequired = subjectsRequired;
    }

}